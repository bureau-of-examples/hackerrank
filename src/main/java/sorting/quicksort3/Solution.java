package sorting.quicksort3;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/quicksort3
 */
public class Solution {

    static void quickSort(int[] ar) {
        quickSort(ar, 0, ar.length - 1);
    }

    //left to right
    private static void quickSort(int[] ar, int start, int end) {
        if (start >= end)
            return;

        int pivot = ar[end];
        int tail = -1;
        int rIndex = -1;
        for (int i = 0; i < end; i++) {
            if (rIndex == -1) {
                if (ar[i] >= pivot)
                    rIndex = i;
                else
                    tail = i;
            } else {
                if (ar[i] < pivot) {
                    int temp = ar[rIndex];
                    ar[rIndex] = ar[i];
                    ar[i] = temp;
                    tail = rIndex;
                    rIndex++;
                }
            }
        }
        ar[end] = ar[tail + 1];
        ar[tail + 1] = pivot;
        printArray(ar);

        quickSort(ar, start, tail);
        quickSort(ar, tail + 2, end);

    }

    static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        quickSort(ar);
    }

    private static void quickSortRightToLeft(int[] ar, int start, int end) {
        if (start >= end)
            return;

        int pivot = ar[end];
        int geStart = end;
        int lIndex = -1;
        for (int i = end - 1; i >= start; i--) {
            if (lIndex == -1) {
                if (ar[i] < pivot)
                    lIndex = i;
                else
                    geStart = i;
            } else {
                if (ar[i] >= pivot) {
                    int temp = ar[i];
                    ar[i] = ar[lIndex];
                    ar[lIndex] = temp;
                    geStart = lIndex;
                    lIndex = geStart - 1;
                }
            }
        }
        ar[end] = ar[geStart];
        ar[geStart] = pivot;
        printArray(ar);

        quickSortRightToLeft(ar, start, geStart - 1);
        quickSortRightToLeft(ar, geStart + 1, end);

    }

    private static void quickSortSideToMiddle(int[] ar, int start, int end) {
        if (start >= end)
            return;

        int pivot = ar[end];
        int geStart = end;
        int i = start, j = end - 1;
        while (i <= j) {
            if (ar[j] < pivot) {
                if (ar[i] >= pivot) {
                    int temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                    geStart = j;
                    j--;
                    i++;
                } else {
                    i++;
                }
            } else {
                geStart = j;
                j--;
            }
        }
        ar[end] = ar[geStart];
        ar[geStart] = pivot;
        printArray(ar);

        quickSortSideToMiddle(ar, start, geStart - 1);
        quickSortSideToMiddle(ar, geStart + 1, end);

    }

    private static void quickSortClassic(int[] ar, int start, int end) {
        if (start >= end)
            return;

        int pivot = ar[end];
        int tail = end - 1; //last index of < sub-list
        for (int i = end - 1; i >= start; i--) {
            if (ar[i] >= pivot) {
                if (i != tail) {
                    int temp = ar[i];
                    ar[i] = ar[tail];
                    ar[tail] = temp;
                }
                tail--;
            }
        }
        ar[end] = ar[tail + 1];
        ar[tail + 1] = pivot;
        printArray(ar);

        quickSortClassic(ar, start, tail);
        quickSortClassic(ar, tail + 2, end);
    }


}
