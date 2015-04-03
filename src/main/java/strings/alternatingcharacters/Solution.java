package strings.alternatingcharacters;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/alternating-characters
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for(int i=0; i < numTestCase; i++){
            String s = in.nextLine();
            System.out.println(minDelete(s));
        }
    }

    private static int minDelete(String s) {
        int count = 0;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1))
                count++;
        }
        return count;
    }
}
