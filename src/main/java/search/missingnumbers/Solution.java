package search.missingnumbers;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/missing-numbers
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] first = new int[n];
        for(int i=0; i<n; i++){
            first[i] = in.nextInt();
        }
        in.nextLine();
        int m = Integer.parseInt(in.nextLine());
        int[] second = new int[m];
        for(int i=0; i<m; i++){
           second[i] = in.nextInt();
        }
        solve(first, second);
    }

    private static void solve(int[] first, int[] second) {
        int min = second[0];
        for(int i=1; i<second.length; i++){
            if(second[i] < min)
                min = second[i];
        }
        int[] counts = new int[100];
        for(int i=0; i<second.length; i++){
            counts[second[i] - min]++;
        }

        for(int i=0; i<first.length; i++){
            counts[first[i] - min]--;
        }

        boolean f = true;
        int index = 0;
        for(int c : counts){
            if(c > 0){
                if(f)
                    f = false;
                else
                    System.out.print(" ");

                System.out.print(index + min);
            }
            index++;
        }
        System.out.println();
    }
}
