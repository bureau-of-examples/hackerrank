package warmup.sherlockandgcd;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-gcd
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = in.nextInt();
        for(int i=0; i<numTestCase; i++){
           in.nextLine();
            int n = in.nextInt();
            in.nextLine();
            int[] buffer = new int[n];
            for(int j=0; j<n; j++){
               buffer[j] = in.nextInt();
            }
            System.out.println(solve(buffer) ? "YES" : "NO");
        }

    }

    private static boolean solve(int[] buffer) {
        for(int i=0; i<buffer.length; i++){
            for(int j=i+1; j<buffer.length; j++){
                if(buffer[i] != buffer[j] && gcd(buffer[i], buffer[j]) == 1)
                    return true;
            }
        }
        return false;
    }

    public static int gcd(int a, int b){
        int r = b % a;
        while (r != 0){
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }
}
