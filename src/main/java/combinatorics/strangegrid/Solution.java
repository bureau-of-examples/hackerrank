package combinatorics.strangegrid;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/strange-grid
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long r = in.nextInt();
        long c = in.nextInt();

        long val = 0;
        val += 10 * ((r - 1) / 2);
        if(r % 2 == 0){
           val += 1 + 2*(c - 1);
        } else {
           val += 2 * (c - 1);
        }
        System.out.println(val);
    }
}
