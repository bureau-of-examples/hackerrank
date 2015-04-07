package sorting.quicksort1;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/quicksort1
 */
public class Solution {
    static void partition(int[] ar) {
        int pivot = ar[0];
        int[] buffer = new int[ar.length];
        int start = 0;
        for(int i=1; i<ar.length;i++){
            if(ar[i] < pivot)
                buffer[start++] = ar[i];
        }
        buffer[start] = pivot;
        int end = ar.length - 1;
        for(int j=ar.length-1; j>=1; j--){
            if(ar[j] > pivot)
                buffer[end--] = ar[j];
        }
        printArray(buffer);
    }

    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
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
        partition(ar);
    }
}
