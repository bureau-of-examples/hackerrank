package dynamicprogramming.redjohnisback;

import java.util.BitSet;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/red-john-is-back
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for (int t = 0; t < numTestCase; t++) {
            System.out.println(solve(Integer.parseInt(in.nextLine())));
        }
    }

    private static int solve(int width) {
        int[] dp = new int[width + 1];//check that the number of ways will not overflow int.
        dp[0] = 1;
        for (int i = 1; i <= width; i++) {
            int ways = dp[i - 1];
            if (i >= 4)
                ways += dp[i - 4];
            dp[i] = ways;
        }

        return primeCount(dp[width]);
    }

    private static int primeCount(int n) {
        if (n <= 3)
            return n - 1;

        BitSet bitSet = new BitSet(n + 1);
        int sqrtN = (int) Math.sqrt((double) n + 1);
        for (int i = 3; i <= sqrtN; i += 2) {
            if (!bitSet.get(i)) {
                int j = 2 * i;
                while (j <= n) {
                    bitSet.set(j);
                    j += i;
                }
            }
        }

        int count = 1;
        for (int i = 3; i <= n; i += 2) {
            if (!bitSet.get(i))
                count++;
        }
        return count;
    }
}
