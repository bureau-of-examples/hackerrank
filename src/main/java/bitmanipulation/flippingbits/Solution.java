package bitmanipulation.flippingbits;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/flipping-bits
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for (int t = 0; t < numTestCase; t++) {
            long n = Long.parseLong(in.nextLine());
            System.out.println(0xFFFFFFFFL & ~(int)n);
        }
    }
}
