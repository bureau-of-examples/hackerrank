package combinatorics.handshake;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/handshake
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for (int t = 0; t < numTestCase; t++) {
            int n = Integer.parseInt(in.nextLine());
            System.out.println(n * (n-1) / 2);
        }
    }
}
