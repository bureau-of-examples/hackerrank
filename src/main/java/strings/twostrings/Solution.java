package strings.twostrings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/two-strings
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numTestCase; i++) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();

            System.out.println(hasCommonChar(s1, s2) ? "YES" : "NO");

        }
    }

    private static boolean hasCommonChar(String s1, String s2) {

        boolean[] found = new boolean[26];
        int count = 0;
        for(char ch : s1.toCharArray()){
            if(!found[ch - 'a']){
                count++;
                found[ch - 'a'] = true;
            }
        }
        for (char ch : s2.toCharArray()){
            if(found[ch - 'a'])
                return true;
        }
        return false;
    }
}
