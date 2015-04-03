package strings.pangrams;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/pangrams
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(isPangram(s) ? "pangram" : "not pangram");
    }

    private static boolean isPangram(String s) {
        int count = 0;
        boolean[] found = new boolean[26];
        for(char ch : s.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                int index =  ch - 'a';
                if(!found[index]) {
                    found[index] = true;
                    count++;
                }
            } else if (ch >= 'A' && ch <= 'Z'){
               int index = ch - 'A';
                if(!found[index]) {
                    found[index] = true;
                    count++;
                }
            }
            if(count == 26)
                return true;
        }
        return false;
    }
}
