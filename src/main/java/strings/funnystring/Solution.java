package strings.funnystring;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/funny-string
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for(int i=0; i<numTestCase; i++){
            System.out.println(isFunny(in.nextLine()) ? "Funny" : "Not Funny");
        }
    }

    private static boolean isFunny(String s) {
        for(int i=1; i<s.length(); i++){
            int j = s.length() - 1 - i;
            if(Math.abs(s.charAt(i) - s.charAt(i - 1)) != Math.abs(s.charAt(j) - s.charAt(j+1)))
                return false;
        }
        return true;
    }
}
