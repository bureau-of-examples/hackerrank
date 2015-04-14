package dynamicprogramming.candies;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/candies
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] ratings = new int[n];
        for (int i = 0; i < n; i++) {
            ratings[i] = Integer.parseInt(in.nextLine());
        }
        System.out.println(solve(ratings));
    }

    private static int solve(int[] ratings) {

        int candies[] = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1])
                candies[i] = candies[i + 1] + 1;
        }

        int count = 0;
        for (int c : candies) count += c;
        return count;
    }

}
