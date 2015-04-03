package strings.gemstones;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/gem-stones
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] counts = new int[26];
        boolean[] flags = new boolean[26];
        for(int i=0; i<n; i++){

            String s = in.nextLine();
            for(char ch : s.toCharArray()){
                int index = ch - 'a';
                if(!flags[index]){
                    counts[index]++;
                    flags[index] = true;//have encountered this char
                }
            }
            Arrays.fill(flags, false);
        }

        int result = 0;
        for (int c : counts){
            if(c == n)
                result++;
        }
        System.out.println(result);
    }
}
