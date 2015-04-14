package dynamicprogramming.themaximumsubarray;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/stockmaximaze
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numTestCase; i++) {
            int n = Integer.parseInt(in.nextLine());
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = in.nextInt();
            }
            if (in.hasNextLine())
                in.nextLine();
            System.out.print(solveContiguous(array));
            System.out.print(" ");
            System.out.print(solveNonContiguous(array));
            System.out.println();
        }
    }

    private static int solveContiguous(int[] array) {

        int max = Integer.MIN_VALUE;
        int maxHere = 0;
        for (int i = 0; i < array.length; i++) {
            if (maxHere <= 0)
                maxHere = array[i];
            else
                maxHere += array[i];

            if (maxHere > max)
                max = maxHere;
        }
        return max;

    }

    private static int solveNonContiguous(int[] array) {
        int sum = 0;
        int maxNegative = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0)
                sum += array[i];
            else if (array[i] > maxNegative)
                maxNegative = array[i];
        }
        return sum > 0 ? sum : maxNegative;
    }
}
