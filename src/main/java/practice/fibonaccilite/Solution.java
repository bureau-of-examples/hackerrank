package practice.fibonaccilite;

import java.util.*;

/**
 * https://www.hackerrank.com/contests/programming-interview-questions/challenges/fibonacci-lite
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = fibo(n);
        System.out.println(result);
    }

    private static int fibo(int n) {
        if(n <= 1)
            return n;

        int previous = 0;
        int current = 1;

        for(int i=2; i<=n; i++) {
            int next = previous + current;
            previous = current;
            current = next;
        }
        return current;

    }
}
