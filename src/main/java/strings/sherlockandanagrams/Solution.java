package strings.sherlockandanagrams;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams
 * todo check how others solved this.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numTestCase; i++) {
            System.out.println(anagramPairCount(in.nextLine()));
        }
    }

    private static int anagramPairCount(String s) {
        int count = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                int len = s.length() - j;

                for (int k = 0; k < len; k++) {
                    char ch1 = s.charAt(i + k);
                    char ch2 = s.charAt(j + k);

                    if (ch1 != ch2) {
                        Integer c = charMap.get(ch1);
                        if (c == null) {
                            charMap.put(ch1, 1);
                        } else if (c == -1) {
                            charMap.remove(ch1);
                        } else {
                            charMap.put(ch1, c + 1);
                        }

                        c = charMap.get(ch2);
                        if (c == null) {
                            charMap.put(ch2, -1);
                        } else if (c == 1) {
                            charMap.remove(ch2);
                        } else {
                            charMap.put(ch2, c - 1);
                        }
                    }
                    if (charMap.size() == 0)
                        count++;
                }
                charMap.clear();
            }
        }
        return count;
    }
}
