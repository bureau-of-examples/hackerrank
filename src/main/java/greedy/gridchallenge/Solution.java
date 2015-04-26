package greedy.gridchallenge;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/grid-challenge
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for (int t = 0; t < numTestCase; t++) {
            int n = Integer.parseInt(in.nextLine());
            char[][] grid = new char[n][];
            for (int i = 0; i < n; i++) {
                grid[i] = in.nextLine().toCharArray();
            }
            System.out.println(solve(grid, n) ? "YES" : "NO");
        }

    }

    private static boolean solve(char[][] grid, int n) {
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                counts[grid[i][j] - 'a']++;
            }
            int index = 0;
            for (int k = 0; k < 26; k++) {
                while (counts[k] > 0) {
                    grid[i][index++] = (char) (k + 'a');
                    counts[k]--;
                }
            }
            if (i > 0) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] < grid[i - 1][j])
                        return false;
                }
            }
        }
        return true;
    }
}
