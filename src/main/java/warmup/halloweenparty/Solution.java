package warmup.halloweenparty;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/halloween-party
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = in.nextInt();
        for(int i=0; i<numTestCase; i++){
            in.nextLine();
            long num = in.nextInt();
            System.out.println(num/2 * ((num+1)/2));
        }
    }
}
