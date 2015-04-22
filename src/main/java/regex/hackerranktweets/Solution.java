package regex.hackerranktweets;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/challenges/hackerrank-tweets
 */
public class Solution {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\bhackerrank\\b", Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numLines = Integer.parseInt(in.nextLine());
        int count = 0;
        for(int l=0; l<numLines; l++){
            String str = in.nextLine();
            Matcher matcher = pattern.matcher(str);
            if(matcher.find())
                count++;
        }
        System.out.println(count);
    }
}
