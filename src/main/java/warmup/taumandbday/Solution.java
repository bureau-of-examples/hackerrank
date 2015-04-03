package warmup.taumandbday;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/taum-and-bday
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = in.nextInt();
        for (int i = 0; i < numTestCase; i++) {
            in.nextLine();
            int b = in.nextInt();
            int w = in.nextInt();
            in.nextLine();
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            solve(b, w, x, y, z);
        }
    }

    private static void solve(long b, long w, long x, long y, long z) {
        if(x > y + z){
            System.out.println(b * (y + z) + w * y);
        } else if(y > x + z){
            System.out.println(b * x + w * (x + z));
        } else {
            System.out.println(b * x + w * y);
        }
    }
}
