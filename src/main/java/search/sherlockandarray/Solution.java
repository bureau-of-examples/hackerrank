package search.sherlockandarray;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-array
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for(int t = 0; t<numTestCase; t++){
            int n = Integer.parseInt(in.nextLine());
            String[] values = in.nextLine().split("\\s");
            int[] array = new int[n];
            for(int i=0; i<n; i++){
                array[i] = Integer.parseInt(values[i]);
            }
            System.out.println(solve(array) ? "YES" : "NO");
        }
    }

    private static boolean solve(int[] array) {
        int[] sumLeft = new int[array.length];
        for(int i=1; i<array.length;i++){
            sumLeft[i] = sumLeft[i-1] + array[i-1];
        }

        int[] sumRight = new int[array.length];
        for(int i=1; i<array.length;i++){
            sumRight[array.length - 1 - i] = sumRight[array.length - i] + array[array.length - i];
        }

        for(int i=0; i<array.length; i++){
            if(sumLeft[i] == sumRight[i])
                return true;
        }
        return false;
    }
}
