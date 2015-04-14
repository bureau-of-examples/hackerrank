package regex.validpanformat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.hackerrank.com/challenges/valid-pan-format
 */
public class Solution {

    private static boolean isValidPAN(String s) {
       return s.matches("^[A-Z]{5}[0-9]{4}[A-Z]$");
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int i = Integer.parseInt(br.readLine());
            for (int j = 0; j < i; j++) {
                String s = br.readLine();
                System.out.println(isValidPAN(s) ? "YES" : "NO");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
