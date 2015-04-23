package bitmanipulation.cipher;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/cipher
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split("\\s+");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        char[] bits = in.nextLine().toCharArray();
        char[] result = solve(n, k, bits);
        System.out.println(result);
    }

    private static char[] solve(int n, int k, char[] bits) {
        char[] result = new char[n];
        int accumulated = 0;
        for (int i = 0; i < n; i++) {

            result[i] = (char)(((bits[i] - '0') ^ accumulated) + '0');
            accumulated ^= result[i] - '0';
            if (i >= k - 1)
                accumulated ^= result[i - (k - 1)] - '0';
        }
        return result;
    }
}
