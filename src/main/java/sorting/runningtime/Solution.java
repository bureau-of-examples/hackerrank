package sorting.runningtime;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/runningtime
 */
public class Solution {

    public static void insertionSort(int[] A){
        long shiftCount = 0;
        for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i - 1;
            while(j >= 0 && A[j] > value){
                A[j + 1] = A[j];
                j = j - 1;
                shiftCount++;
            }
            A[j + 1] = value;
        }

        System.out.println(shiftCount);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        insertionSort(ar);
    }
}
