package sorting.countingsort2;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/countingsort2
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] counts = new int[100];
        for(int i=0; i<n; i++){
            counts[in.nextInt()]++;
        }
        for(int i=0; i<counts.length; i++){
            for(int j=0; j<counts[i]; j++){
                System.out.print(i);
                System.out.print(' ');
            }
        }
        System.out.println();
    }
}
