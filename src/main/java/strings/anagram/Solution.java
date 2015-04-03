package strings.anagram;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/anagram
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for(int i=0; i<numTestCase; i++){
           System.out.println(diff(in.nextLine()));
        }

    }

    private static int diff(String s) {
        if(s.length() % 2 == 1)
            return -1;
        int[] counts = new int[26];
        int half = s.length() / 2;
        for(int i=0; i<half; i++){
            counts[s.charAt(i) - 'a']++;
            counts[s.charAt(half + i) - 'a']--;
        }
        int count = 0;
        for(int c : counts){
            if(c > 0)
                count+= c;
        }
        return count;
    }
}
