package graphtheory.gridwalking;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/grid-walking
 * This dp solution is attributed to:
 * http://blog.csdn.net/kindlucy/article/details/8002435
 */
public class Solution {

    private static final long modConstant = 1000000007L;

    private static final int[][] c = new int[301][301];

    public static void main(String[] args) {

        calcC();
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for (int t = 0; t < numTestCase; t++) {
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();

            String[] parts = in.nextLine().split("\\s+");
            int[] pos = new int[n];
            int index = 0;
            for (String val : parts) {
                pos[index++] = Integer.valueOf(val);
            }

            parts = in.nextLine().split("\\s+");
            int[] dim = new int[n];
            index = 0;
            for (String val : parts) {
                dim[index++] = Integer.valueOf(val);
            }


            System.out.println(solveDp(n, m, pos, dim));
        }

    }

    /**
     * Calculate C(i,j) = number of ways to choose j items from i items.
     * C(i,j) = C(i-1, j-1) + C(i-1,j)
     * C(0,0) = 1
     * C(0,j) = 0 where j > 0
     * C(i,0) = C(i,i) = 1 where i > 0
     */
    private static void calcC() {

        c[0][0] = 1;
        for (int i = 1; i < c.length; i++) {

            c[i][0] = c[i][i] = 1;
            for (int j = 1; j < i; j++) {
                c[i][j] = (int) (((long) c[i - 1][j - 1] + c[i - 1][j]) % modConstant);
            }
        }
    }

    /**
     * D[i][k][j] = number of k-step walks that starts at j in dimension i.
     * All counted walks are confined in dimension i. This means at each step the walks can only change position component i.
     * D[i][k][j] = D[i][k-1][j-1] + D[i][k-1][j+1]
     * D[i][0][j] = 1
     */
    private static int[][][] calcD(int n, int m, int[] dim) {
        int[][][] d = new int[n][][];
        for (int i = 0; i < n; i++) {
            d[i] = new int[m + 1][dim[i]];
            Arrays.fill(d[i][0], 1); //k=0

            for (int k = 1; k <= m; k++) {
                for (int j = 0; j < dim[i]; j++) {
                    d[i][k][j] = (int) (((j - 1 < 0 ? 0 : (long) d[i][k - 1][j - 1]) + (j + 1 < dim[i] ? (long) d[i][k - 1][j + 1] : 0)) % modConstant);
                }
            }
        }

        return d;
    }

    /**
     * DP[i][k] = number of k-step walks in dimension 0~i.
     * DP[i][k] = Sum(C[k][r]*DP[i-1][r]*D[i][pos[i]][k-r]) for r in [0,k].
     * DP[0][k] = D[0][k][pos[0]]
     * The meaning of r is steps made in 0~i-1 dimensions, then k-r is steps made in dimension i.
     * DP[i-1][r]*D[i][pos[i]][k-r] = first r steps are in dimension 0~i-1, and the last k-r steps are in dimension i.
     * C[k][r]*... means of the k steps, we select which r steps to be made in dimension 0~i-1.
     * Moving in dimension i is independent of other dimensions.
     */
    private static int solveDp(int n, int m, int[] pos, int[] dim) {
        int[][][] d = calcD(n, m, dim);
        int[][] dp = new int[n][m + 1];
        for (int k = 0; k <= m; k++) {//i=0
            dp[0][k] = d[0][k][pos[0] - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int k = 0; k <= m; k++) {
                int sum = 0;
                for (int r = 0; r <= k; r++) {
                    sum = (int) ((sum + (((long) c[k][r] * dp[i - 1][r] % modConstant) * d[i][k - r][pos[i] - 1]) % modConstant) % modConstant);
                }
                dp[i][k] = sum;
            }
        }
        return dp[n - 1][m];

    }


}
