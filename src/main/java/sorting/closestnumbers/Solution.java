package sorting.closestnumbers;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/closest-numbers
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = in.nextInt();
        Arrays.sort(array);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int diff = array[i] - array[i - 1];
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        boolean first = true;
        for (int i = 1; i < n; i++) {
            int diff = array[i] - array[i - 1];
            if (diff == minDiff) {
                if (first)
                    first = false;
                else
                    System.out.print(' ');

                System.out.print(array[i - 1]);
                System.out.print(' ');
                System.out.print(array[i]);

            }
        }
        System.out.println();

    }


}
