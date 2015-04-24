package combinatorics.pickingcards;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/picking-cards
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = in.nextInt();
        for(int t=0; t<numTestCase;t++){
            in.nextLine();
            int n = Integer.parseInt(in.nextLine());
            int[] cards = new int[n];
            for(int i=0; i<cards.length; i++){
                cards[i] = in.nextInt();
            }
            System.out.println(solve(cards));
        }
    }

    private static int solve(int[] cards) {
        Arrays.sort(cards);
        long result = 1;
        for(int i=0; i<cards.length; i++){
            if(cards[i] > i)
                return 0;
            result = result * (i - cards[i] + 1) % 1000000007;
        }
        return (int)result;
    }
}
