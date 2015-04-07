package sorting.countingsort1;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/countingsort1
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] counts = new int[100];
        for(int i=0; i<n; i++){
            counts[in.nextInt()]++;
        }
        for(int c : counts){
            System.out.print(c);
            System.out.print(' ');
        }
        System.out.println();
    }
}
