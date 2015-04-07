package sorting.countingsort3;

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
            int key = Integer.parseInt(in.nextLine().split("\\s+")[0]);
            counts[key]++;
        }
        int count = 0;
        for(int i=0; i<counts.length; i++){
            count += counts[i];
            System.out.print(count);
            System.out.print(" ");
        }
        System.out.println();
    }
}
