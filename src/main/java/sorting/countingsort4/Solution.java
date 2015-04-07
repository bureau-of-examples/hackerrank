package sorting.countingsort4;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/countingsort2
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int dashCount = n / 2;
        int[] counts = new int[100];
        int[] keys = new int[n];
        String[] values = new String[n];
        for(int i=0; i<n; i++){
            String str = in.nextLine();
            String[] parts = str.split("\\s+");
            int key = Integer.parseInt(parts[0]);
            counts[key]++;
            keys[i] = key;
            values[i] = i < dashCount ? "-" : parts[1];
        }
        for(int i=1; i<counts.length; i++){
            counts[i] += counts[i-1];
        }

        String[] sorted = new String[n];
        for(int i=n - 1; i>=0; i--){
            sorted[--counts[keys[i]]] = values[i];
        }

        StringBuilder sb = new StringBuilder();
        for(String str : sorted){
            sb.append(str);
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}
