package greedy.chiefhopper;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/chief-hopper
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] heights = new int[n + 1];
        heights[0] = 0;
        for (int i = 1; i <= n; i++) {
            heights[i] = in.nextInt();
        }

        System.out.println(solve(heights, n));
    }

    private static long solve(int[] heights, int n) {
        long needed = 0;
        for(int i=n; i>0; i--){
            boolean isOdd = (heights[i] + needed) % 2 == 1;
            needed = (heights[i] + needed) / 2;
            if(isOdd)
                needed++;
        }
        return needed;
    }
}
