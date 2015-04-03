package strings.makeitanagram;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/make-it-anagram
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(anagramDiff(in.nextLine(), in.nextLine()));

    }

    private static int anagramDiff(String s1, String s2) {
        int[] counts = new int[26];
        for(char ch : s1.toCharArray()){
            counts[ch - 'a']++;
        }
        for(char ch : s2.toCharArray()){
            counts[ch - 'a']--;
        }
        int count = 0;
        for(int c : counts){
            count += c < 0 ? -c : c;
        }
        return count;
    }
}
