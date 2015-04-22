package dynamicprogramming.thecoinchangeproblem;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/coin-change
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split("\\s+");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        str = in.nextLine().split("\\s+");
        int[] denom = new int[m];
        for (int i = 0; i < m; i++) {
            denom[i] = Integer.parseInt(str[i]);
        }

        System.out.println(solve(n, denom));

    }

    private static long solve(int n, int[] denom) {
        long[][] dp = new long[n + 1][denom.length]; //dp[i][j] = number of ways to make change for $i with denom[0]~denom[j]
        Arrays.sort(denom);
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i % denom[0] == 0 ? 1 : 0;
            for (int j = 1; j < denom.length; j++) {
                int remaining = i - denom[j];
                long sum = 0;
                while (remaining >= 0) {
                    sum += dp[remaining][j - 1];
                    remaining -= denom[j];
                }
                dp[i][j] = sum + dp[i][j-1];
            }
        }
        return dp[n][denom.length - 1];
    }
}
