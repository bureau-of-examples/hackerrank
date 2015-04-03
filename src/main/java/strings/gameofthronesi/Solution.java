package strings.gameofthronesi;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/game-of-thrones
 */
public class Solution {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
        String ans = canBeAnagram(inputString) ? "YES" : "NO";
        System.out.println(ans);
        myScan.close();
    }

    private static boolean canBeAnagram(String inputString) {
        boolean[] flags = new boolean[26];
        int singleCount = 0;
        for(char ch : inputString.toCharArray()){
            int index = ch - 'a';
            if(flags[index]){
                flags[index] = false;
                singleCount--;
            } else {
                flags[index] = true;
                singleCount++;
            }
        }
        return singleCount <= 1;
    }
}
