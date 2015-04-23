package greedy.twoarrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/two-arrays
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = in.nextInt();
        for(int t=0; t<numTestCase; t++){
            in.nextLine();
            String[] str = in.nextLine().split("\\s+");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            int[] a = new int[n];
            for(int i=0; i<n; i++){
                a[i] = in.nextInt();
            }
            in.nextLine();
            int[] b = new int[n];
            for(int i=0; i<n; i++){
                b[i] = in.nextInt();
            }
            System.out.println(solve(a,b,n,k) ? "YES" : "NO");
        }

    }

    private static boolean solve(int[] a, int[] b, int n, int k) {
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=0; i<n; i++){
            if(a[i] + b[n-1-i] < k)
                return false;
        }
        return true;
    }

}
