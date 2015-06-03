package dynamicprogramming.thelongestcommonsubsequence;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        int[] A = readIntArray(in);
        int[] B = readIntArray(in);
        int[] C = solve(A, B);

        //print result
        StringBuilder stringBuilder = new StringBuilder();
        boolean isFirst = true;
        for (int val : C) {
            if (isFirst)
                isFirst = false;
            else
                stringBuilder.append(" ");

            stringBuilder.append(val);
        }
        System.out.println(stringBuilder.toString());
    }

    private static int[] solve(int[] a, int[] b) {

        int[] dp = new int[b.length + 1]; //dp previous row
        char[][] trace = new char[a.length + 1][b.length + 1];
        for (int i = 1; i <= a.length; i++) {
            int aIndex = i - 1;
            int dpLeft = 0;
            int dpHere = 0;
            for (int j = 1; j <= b.length; j++) {
                int bIndex = j - 1;
                dpHere = dpLeft;
                char from = 'L';
                if (dp[j] > dpHere) {
                    dpHere = dp[j];
                    from = 'T';
                }

                if (a[aIndex] == b[bIndex] && dp[bIndex] >= dpHere) {
                    dpHere = dp[bIndex] + 1;
                    from = 'D';//diagonal
                }

                dp[bIndex] = dpLeft;
                dpLeft = dpHere;
                trace[i][j] = from;
            }

            dp[b.length] = dpHere;
        }

        //trace to start
        int[] result = new int[dp[b.length]];
        int index = result.length - 1;
        int i = a.length;
        int j = b.length;

        while (index >= 0) {
            char from = trace[i][j];
            switch (from) {
                case 'L':
                    j--;
                    break;
                case 'T':
                    i--;
                    break;
                case 'D':
                    result[index--] = b[j - 1];
                    i--;
                    j--;
                    break;
                default:
                    throw new RuntimeException();
            }
        }
        return result;
    }


    private static int[] readIntArray(Scanner in) {
        String[] values = in.nextLine().split("\\s+");
        int[] result = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = Integer.parseInt(values[i]);
        }
        return result;
    }
}
