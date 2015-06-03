package sorting.almostsorted;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/almost-sorted
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        if(checkSwap(array))
            return;

        if(checkReverse(array))
            return;

        System.out.println("No");
    }

    private static boolean checkReverse(int[] array) {
        return false;  //To change body of created methods use File | Settings | File Templates.
    }

    private static boolean checkSwap(int[] array) {
        return false;
    }
}
