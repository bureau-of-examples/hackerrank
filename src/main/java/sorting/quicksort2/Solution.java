package sorting.quicksort2;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/quicksort2
 */
public class Solution {

    private static int[] buffer;

    static void quickSort(int[] ar) {
        buffer = new int[ar.length];
        quickSort(ar, 0, ar.length - 1);
    }

    private static void quickSort(int[] ar, int start, int end) {
        if(start >= end)
            return;

        //partition
        int pivot = ar[start];
        int leftIndex = start;
        for(int i=start + 1; i<=end; i++){
            if(ar[i] <= pivot){
                buffer[leftIndex++] = ar[i];
            }
        }
        int rightIndex = end;
        buffer[leftIndex] = pivot;
        for(int i=end; i>start; i--){
           if(ar[i] > pivot){
               buffer[rightIndex--] = ar[i];
           }
        }
        System.arraycopy(buffer, start, ar, start, end - start + 1);

        //recursion
        quickSort(ar, start, leftIndex - 1);
        quickSort(ar, leftIndex + 1, end);

        printArray(ar, start, end);
    }

    static void printArray(int[] ar, int start, int end) {
        for(int i=start; i<=end; i++){
            System.out.print(ar[i]+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        quickSort(ar);
    }
}
