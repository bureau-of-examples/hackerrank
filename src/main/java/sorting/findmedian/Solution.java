package sorting.findmedian;

import java.util.Random;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/find-median
 */
public class Solution {

    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        System.out.println(findKth(array, 0, n - 1, n / 2));
    }

    private static int findKth(int[] array, int start, int end, int k) {
        int count = end - start + 1;
        if (count <= 2)
            return array[start];

        int p = random.nextInt(count);
        p += start;
        swap(array, start, p);

        int pEnd = start;//inclusive
        for (int i = start + 1; i <= end; i++) {
            if (array[i] <= array[start]) {
                swap(array, i, ++pEnd);
            }
        }

        int leftCount = pEnd - start;
        if (leftCount == k) {
            return array[start];
        }
        if (leftCount > k) {
            return findKth(array, start + 1, pEnd, k);
        } else {
            return findKth(array, pEnd + 1, end, k - leftCount - 1);
        }

    }

    private static void swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

}
