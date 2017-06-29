package strings.separatethenumbers;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/separate-the-numbers
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            System.out.println(canSplit(s));
        }
    }

    private static String canSplit(String s) {
        if (s.charAt(0) != '0') {
            for (int i = 1; i <= s.length() / 2; i++) {
                String result = canSplit(s, i);
                if (result != null)
                    return result;
            }
        }
        return "NO";
    }



    private static String canSplit(String s, int len) {
        String firstStr = s.substring(0, len);
        long next = Long.parseLong(firstStr) + 1;
        int startIndex = len;
        while (startIndex < s.length()) {
            String nextStr = String.valueOf(next);
            int endIndex = startIndex + nextStr.length();
            if (endIndex > s.length())
                return null;
            if (nextStr.equals(s.substring(startIndex, endIndex))) {
                startIndex = endIndex;
                next++;
            } else {
                return null;
            }
        }
        return startIndex == s.length() ? "YES " + firstStr : null;
    }
}
