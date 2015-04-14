package dynamicprogramming.stockmaximaze;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/stockmax
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numTestCase; i++) {
            int n = Integer.parseInt(in.nextLine());
            int[] prices = new int[n];
            for (int j = 0; j < n; j++) {
                prices[j] = in.nextInt();
            }
            if (in.hasNextLine())
                in.nextLine();
            System.out.println(solve(prices));

        }
    }

    private static long solve(int[] prices) {
        int highestToTheRight = prices[prices.length - 1];
        long profit = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] < highestToTheRight)
                profit += highestToTheRight - prices[i];

            if (prices[i] > highestToTheRight) {
                highestToTheRight = prices[i];
            }
        }
        return profit;
    }
}
