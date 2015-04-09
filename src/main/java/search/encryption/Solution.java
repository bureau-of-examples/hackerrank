package search.encryption;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/encryption
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String plaintext = in.nextLine();
        System.out.println(encrypt(plaintext));
    }

    private static String encrypt(String plaintext) {
        int l = plaintext.length();
        int low = 1, high = plaintext.length();
        while (low <= high){
           int mid = (low + high) >>> 1;
           int square = mid * mid;
           if(square == l) {
               low = high = mid;
               break;
           }
           if(square < l){
               low = mid + 1;
           } else {
               high = mid - 1;
           }
        }
        if(low > high){
            int temp = low;
            low = high;
            high = temp;
            if(high * low < l)
                low = high;
        }
        return fill(plaintext, low, high);
    }

    private static String fill(String s, int row, int col){
        char[] buffer = new char[s.length() + col - 1];
        int index = 0;
        for(int j=0; j<col; j++){
            for(int i=0; i<row; i++){
                int srcIndex = col * i + j;
                if(srcIndex < s.length())
                    buffer[index++] = s.charAt(srcIndex);
            }
            if(j != col - 1){
                buffer[index++] = ' ';
            }
        }
        return new String(buffer);
    }
}
