package greedy.markandtoys;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/mark-and-toys
 */
public class Solution {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt(), k = stdin.nextInt();
        int prices[] = new int[n];
        for (int i = 0; i < n; i++) prices[i] = stdin.nextInt();

        int answer = solve(prices, k);
        // Compute the final answer from n,k,prices
        System.out.println(answer);
    }

    private static int solve(int[] prices, int k) {
        Arrays.sort(prices);
        int count = 0;
        for (int i = 0; i < prices.length; i++) {
            if (k >= prices[i]) {
                k -= prices[i];
                count++;
            } else break;
        }
        return count;
    }
}
