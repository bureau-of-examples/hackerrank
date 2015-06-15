package dynamicprogramming.fibonaccimodified;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/fibonacci-modified
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();

        BigInteger A = BigInteger.valueOf(a);
        BigInteger B = BigInteger.valueOf(b);
        for(int i=3; i<=n; i++){
            BigInteger result = B.multiply(B).add(A);
            A = B;
            B = result;
        }
        System.out.println(B.toString());
    }
}
