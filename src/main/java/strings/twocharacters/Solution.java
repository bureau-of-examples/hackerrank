package strings.twocharacters;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/two-characters/problem
 */
public class Solution {
    private static int calc(String s) {
        if (s.length() == 1)
            return 0;

        int max = 0;
        boolean[] used = new boolean[26];
        for (int i=0; i<s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if (used[ch])
                continue;
            int len = calcLen(s, i, used);
            if (len > max) {
                max = len;
            }
            used[ch] = true;
        }
        return max;
    }

    private static int calcLen(String s, int index, boolean[] used) {
        char ch = s.charAt(index);
        int chCount = 1;
        boolean[] eliminated = Arrays.copyOf(used, 26);
        boolean[] appeared = new boolean[26];
        for (int i=index + 1; i < s.length(); i++) {
            if (ch == s.charAt(i)) {
                boolean hasCandidate = false;
                for(int j=0; j<appeared.length; j++) {
                    if (!appeared[j]) {
                        eliminated[j] = true;
                    }
                    if (!eliminated[j]) {
                        hasCandidate = true;
                    }
                }
                if (!hasCandidate)
                    return 0;
                chCount++;
                appeared = new boolean[26];
            } else {
                int c = s.charAt(i) - 'a';
                if (appeared[c]) {
                    eliminated[c] = true;
                } else {
                    appeared[c] = true;
                }
            }
        }

        int count = 0;
        for (int i=0; i<eliminated.length; i++) {
            if (eliminated[i])
                continue;

            count = chCount * 2;

            int k = s.length() - 1;
            boolean hasTailCandidate = false;
            while (s.charAt(k) != ch) {
                if (!eliminated[s.charAt(k) - 'a']) {
                    hasTailCandidate = true;
                    break;
                }
                k--;
            }
            if (!hasTailCandidate) {
                count--;
            }

            break;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        System.out.println(calc(s));
    }

}
