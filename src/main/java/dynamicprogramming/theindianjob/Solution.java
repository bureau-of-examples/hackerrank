package dynamicprogramming.theindianjob;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-indian-job
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for(int t=0; t<numTestCase; t++){
            int n = in.nextInt();
            int g = Integer.parseInt(in.nextLine().trim());
            int[] a = new int[n];
            String[] times = in.nextLine().split("\\s+");
            for(int i=0; i<n; i++){
                a[i] = Integer.parseInt(times[i]);
            }
            System.out.println(solve(a,g) ? "YES" : "NO");

        }

    }

    private static boolean solve(int[] a, int g) {
        int total = 0;
        for(int time : a){
            total+= time;
        }
        if(total > 2 * g)
            return false;

        int capacity = knapsack(a, g);
        return total - capacity <= g;
    }

    private static int knapsack(int[] items, int capacity) {
        int numItems = items.length;
        int[][] dp = new int[numItems + 1][capacity + 1]; //dp[i][j] = max weight for the first i items when capacity is j
        for(int i=1; i<= numItems; i++){
            int weight = items[i - 1];
            for(int j=1; j<= capacity; j++){
              if(weight > j){ //weight i > current capacity
                  dp[i][j] = dp[i-1][j];
              } else {
                  dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight] + weight);
              }
            }
        }
        return dp[numItems][capacity];
    }
}
