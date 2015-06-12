package dynamicprogramming.equal;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/equal
 * 1. Everyone else gets k chocolate (a) is equivalent to the chosen one gets -k chocolates (b).
 * From the same initial distribution, if we do a series of (a) and do the series of corresponding (b) on an identical distribution, we both get a equal situation.
 * 2. If the final level is (minValue in initial distribution - 5, 6, 7, ...) then we can reach (minValue in initial distribution - 0, 1, 2, ...) with fewer operations.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for (int t = 0; t < numTestCase; t++) {
            int n = Integer.parseInt(in.nextLine());
            int[] values = parseIntArray(n, in.nextLine());
            System.out.println(solve(values));
        }
    }

    private static int solve(int[] values) {
        int n = values.length;
        int minValue = values[0];
        for(int i=1; i<values.length; i++){
            if(values[i] < minValue)
                minValue = values[i];
        }

        int minOp = Integer.MAX_VALUE;
        for(int i=-4; i<=0; i++){   //when final level is minValue-i
            int op = 0;
            for(int j = 0; j<values.length; j++){
                int valueToReduce = values[j] - minValue - i;
                op += valueToReduce / 5 + (valueToReduce % 5) / 2 + (valueToReduce % 5) % 2;
            }
            if(op < minOp)
                minOp = op;
        }

        return minOp;
    }

    private static int[] parseIntArray(int n, String s) {
        int[] array = new int[n];
        String[] values = s.split("\\s+");
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(values[i]);
        }
        return array;
    }
}
