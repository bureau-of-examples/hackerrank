package bitmanipulation.countergame;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/counter-game
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for (int t = 0; t < numTestCase; t++) {
            BigInteger integer = new BigInteger(in.nextLine());
            long n = integer.longValue();
//            long flag = 1;
//            for(int i=0; i<64; i++){
//                if(integer.testBit(i)){
//                    n |= flag;
//                }
//                flag <<= 1;
//            }

            int count = solve(n);
            System.out.println(count % 2 == 0 ? "Richard" : "Louise");
        }
    }

    private static int solve(long n) {  //n > 0
        int count = 0;
        long flag = Long.MIN_VALUE;
        while (n != 1) {
            long newN = ~flag & n;
            if (newN == 0) {
                n >>>= 1;
                count++;
            } else if (newN != n) {
                n = newN;
                count++;
            } else {
                flag >>>= 1;
            }

        }
        return count;
    }
}
