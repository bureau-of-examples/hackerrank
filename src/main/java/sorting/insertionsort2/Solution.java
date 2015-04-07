package sorting.insertionsort2;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/insertionsort2
 */
public class Solution {

    public static void insertionSortPart2(int[] ar)
    {
        for(int i=1; i<ar.length; i++){
            int valToInsert = ar[i];
            int j;
            for(j=i-1; j>=0; j--){
                if(ar[j] > valToInsert){
                    ar[j+1] = ar[j];
                } else
                    break;
            }
            ar[j+1] = valToInsert;
            printArray(ar);
        }
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertionSortPart2(ar);

    }
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
