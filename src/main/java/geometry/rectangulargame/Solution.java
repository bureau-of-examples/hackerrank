package geometry.rectangulargame;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/rectangular-game
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String[] values = in.nextLine().split("\\s+");
            minX = Math.min(Integer.parseInt(values[0]), minX);
            minY = Math.min(Integer.parseInt(values[1]), minY);
        }

        System.out.println((long)minX * minY);
    }
}
