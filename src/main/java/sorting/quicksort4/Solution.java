package sorting.quicksort4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/quicksort4
 */
public class Solution {

    public static long insertionSort(int[] A) {
        long shiftCount = 0;
        for (int i = 1; i < A.length; i++) {
            int value = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > value) {
                A[j + 1] = A[j];
                j = j - 1;
                shiftCount++;
            }
            A[j + 1] = value;
        }

        return shiftCount;
    }

    static long quickSort(int[] ar) {
        return quickSort(ar, 0, ar.length - 1);
    }

    //left to right
    private static long quickSort(int[] ar, int start, int end) {
        if (start >= end)
            return 0;

        int swapCount = 0;
        int pivot = ar[end];
        int tail = start - 1;
        int rIndex = -1;//not set
        for (int i = start; i < end; i++) {
            if (rIndex == -1) {
                if (ar[i] >= pivot)
                    rIndex = i;
                else {
                    tail = i;
                    swapCount++;
                }
            } else {
                if (ar[i] < pivot) {
                    int temp = ar[rIndex];
                    ar[rIndex] = ar[i];
                    ar[i] = temp;
                    tail = rIndex;
                    rIndex++;
                    swapCount++;
                }
            }
        }
        ar[end] = ar[tail + 1];
        ar[tail + 1] = pivot;
        swapCount++;

        swapCount += quickSort(ar, start, tail);
        swapCount += quickSort(ar, tail + 2, end);
        return swapCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        int[] ar2 = Arrays.copyOf(ar, ar.length);
        System.out.println(insertionSort(ar) - quickSort(ar2));
    }

}
