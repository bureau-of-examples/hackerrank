package warmup.finddigits;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/find-digits
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = in.nextInt();
        for(int i=0; i<numTestCase; i++){
            in.nextLine();
            long num = in.nextLong();
            System.out.println(findDigits(num));
        }
    }

    private static int findDigits(long num) {
        boolean[] canDivide = new boolean[10];//2 to 9
        canDivide[1] = true;
        for(int i=2; i<=9; i++) {
            canDivide[i] = num % i == 0;
        }

        int count = 0;
        while (num != 0){
            int digit = (int)(num % 10);
            if(canDivide[digit])
                count++;
            num = num / 10;
        }
        return count;
    }
}
