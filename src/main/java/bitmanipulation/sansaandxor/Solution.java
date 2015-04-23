package bitmanipulation.sansaandxor;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sansa-and-xor
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = in.nextInt();
        for(int t=0; t<numTestCase; t++){
            in.nextLine();
            int n = Integer.parseInt(in.nextLine());
            int[] num = new int[n];
            for(int i=0; i<n; i++){
               num[i] = in.nextInt();
            }
            System.out.println(solve(num));
        }
    }

    private static int solve(int[] num) {
        int result = 0;
        int start = 0, end = num.length - 1;
        int accumulator = 0;
        for(int n : num)
            accumulator ^= n;

        while (start <= end){
            result ^= (end - start) % 2 == 1 ? 0 : accumulator;
            accumulator ^= num[start];
            accumulator ^= num[end];
            start++;
            end--;
        }

        return result;
    }

}
