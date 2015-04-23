package greedy.flowers;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/flowers
 */
public class Solution {

    public static void main( String args[] ){

// helpers for input/output

        Scanner in = new Scanner(System.in);

        int N, K;
        N = in.nextInt();
        K = in.nextInt();

        int C[] = new int[N];
        for(int i=0; i<N; i++){
            C[i] = in.nextInt();
        }

        int result = solve(C, K);
        System.out.println( result );

    }

    private static int solve(int[] c, int k) {

        Arrays.sort(c);
        int count = 0;
        int multiplier = 1;
        int result = 0;
        for(int i=c.length - 1; i>=0; i--){
            result += multiplier * c[i];
            count++;
            if(count == k){
                count = 0;
                multiplier++;
            }
        }

        return result;
    }
}
