package dynamicprogramming.knapsack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/unbounded-knapsack
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for (int t = 0; t < numTestCase; t++) {
            String[] str = in.nextLine().split("\\s+");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            str = in.nextLine().split("\\s+");
            int[] num = new int[n];
            for(int i=0; i<n; i++){
                num[i] = Integer.parseInt(str[i]);
            }
            System.out.println(solve(num, k));
        }
    }

    private static int solve(int[] num, int k) {
        int[][] dp = new int[k+1][num.length];  //closest sum to i when items num[0]~num[j] are available
        Arrays.sort(num);
        for(int i=1; i<=k; i++){
            dp[i][0] = i - i % num[0];
          for(int j=1; j<num.length; j++){
              int max = dp[i][j-1];
              int remaining = i - num[j];
              while (remaining >= 0){
                  max = Math.max(max, i - remaining + dp[remaining][j]);
                  remaining-= num[j];
              }
              dp[i][j] = max;
          }
        }
        return dp[k][num.length - 1];

    }
}
