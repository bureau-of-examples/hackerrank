package sorting.sherlockandwatson;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-watson
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split("\\s+");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        int q = Integer.parseInt(str[2]);
        str = in.nextLine().split("\\s+");
        int[] array = new int[n];
        for(int i=0; i<n; i++)
            array[i] = Integer.parseInt(str[i]);

        for(int i=0; i<q; i++){
            int index = Integer.parseInt(in.nextLine());
            System.out.println(array[(n - k % n + index) % n]);
        }
    }
}
