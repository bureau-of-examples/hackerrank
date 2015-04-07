package sorting.intrototutorial;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/tutorial-intro
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int v = Integer.parseInt(in.nextLine());
        int n = Integer.parseInt(in.nextLine());
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = in.nextInt();
        }
        System.out.println(binSearch(array, v));

    }

    private static int binSearch(int[] array, int v) {
        int start = 0, end = array.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(array[mid] == v)
                return mid;
            if(array[mid] > v)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}
