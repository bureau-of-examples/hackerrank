package sorting.almostsorted;

import java.util.Arrays;
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

        if(isSorted(array)) {
            return;
        }

        int[] sorted = Arrays.copyOf(array, array.length);
        Arrays.sort(sorted);
        int left = 0;
        int right = array.length - 1;
        while (sorted[left] == array[left])
            left++;
        while (sorted[right] == array[right])
            right--;

        swap(array, left, right);
        if(isSorted(array)){
            System.out.println("yes");
            System.out.println("swap " + (left+1) + " " + (right+1));
            return;
        }

        swap(array, left, right);
        reverse(array, left, right);
        if(isSorted(array)){
            System.out.println("yes");
            System.out.println("reverse " + (left+1) + " " + (right+1));
            return;
        }

        System.out.println("no");
    }

    private static boolean isSorted(int[] array){
       for(int i=1; i<array.length; i++)
           if(array[i] < array[i-1])
               return false;

        return true;
    }

    private static void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    private static void reverse(int[] array, int left, int right){
        while (left < right){
            swap(array, left, right);
            left++;
            right--;
        }
    }

}
