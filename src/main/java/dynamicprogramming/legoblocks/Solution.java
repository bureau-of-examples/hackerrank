package dynamicprogramming.legoblocks;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/lego-blocks
 */
public class Solution {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for (int t = 0; t < numTestCase; t++) {
            String[] nm = in.nextLine().split("\\s+");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            System.out.println(solve(n, m));
        }
    }

    private static int solve(int n, int m) {

        int[] totalWays = new int[m + 1];//# of ways to construct a wall of width i without considering if is solid
        totalWays[0] = 1;
        int[] rowWays = rowWays(m);
        for (int i = 1; i <= m; i++) {
            long total = 1;
            for (int j = 0; j < n; j++) {
                total *= rowWays[i];
                total %= MOD;
            }
            totalWays[i] = (int) total;
        }

        int[] solidWays = new int[m + 1];
        solidWays[0] = totalWays[0];
        solidWays[1] = totalWays[1];
        for (int i = 2; i <= m; i++) {

            long notSolidWays = 0;
            for (int slit = 1; slit < i; slit++) {
                notSolidWays += ((long) solidWays[slit] * totalWays[i - slit]) % MOD;
                notSolidWays %= MOD;
            }
            solidWays[i] = totalWays[i] - (int)notSolidWays;
            if(solidWays[i] < 0)
                solidWays[i] += MOD;
        }
        return solidWays[m];

    }

    private static int[] rowWays(int m) {
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 1; i <= m; i++) {
            long cellWays = dp[i - 1];
            if (i - 2 >= 0) {
                cellWays += dp[i - 2];
                cellWays %= MOD;
            }
            if (i - 3 >= 0) {
                cellWays += dp[i - 3];
                cellWays %= MOD;
            }
            if (i - 4 >= 0) {
                cellWays += dp[i - 4];
                cellWays %= MOD;
            }

            dp[i] = (int)cellWays;
        }

        return dp;
    }
}
