package warmup.sherlockandsquares;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-squares
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = in.nextInt();
        for(int i=0; i<numTestCase; i++){
            in.nextLine();
            int start = in.nextInt();
            int end = in.nextInt();
            solve(start, end);
        }
    }

    private static void solve(int start, int end) {
        int sqrtA = (int)Math.sqrt(start);
        int sqrtB = (int)Math.sqrt(end);
        if(sqrtA * sqrtA == start)
            sqrtA--;
        System.out.println(sqrtB - sqrtA);
    }
}
