package dynamicprogramming.bricksgame;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/play-game
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCase = scanner.nextInt();
        for(int t=0; t<numTestCase; t++){
            scanner.nextLine();
            int n = Integer.parseInt(scanner.nextLine());
            int[] bricks = new int[n];
            for(int i=0; i<n; i++){
                bricks[i] = scanner.nextInt();
            }
            System.out.println(solve(bricks));
        }

    }

    private static long solve(int[] bricks) {
        int n = bricks.length;
        long[] scores = new long[n];
        if(bricks.length <= 3) {
            long sum = 0;
            for(int num : bricks){
                sum += num;
            }
            return sum;
        }

        scores[n - 1] = bricks[n-1];
        scores[n - 2] = bricks[n-2] + scores[n - 1];
        scores[n - 3] = bricks[n-3] + scores[n - 2];
        long total = scores[n - 3];
        for(int i=n-4; i>=0; i--){
            total += bricks[i];
            long minNextMove = Math.min(scores[i+1], Math.min(scores[i+2], scores[i+3]));
            scores[i] = total - minNextMove;
        }

        return scores[0];

    }
}
