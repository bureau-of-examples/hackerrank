package warmup.chocolatefeast;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/chocolate-feast
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            System.out.println(Solve(in.nextInt(), in.nextInt(), in.nextInt()));
        }
    }

    private static long Solve(int N, int C, int M){

        long count = N / C;
        long numWraps = count;
        while (numWraps >= M){
            long numChocolate = numWraps / M;
            numWraps -= numChocolate * (M - 1);
            count += numChocolate;
        }

        return count;
    }
}
