package greedy.priyankaandtoys;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/priyanka-and-toys
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] weights = new int[n];
        for(int i=0; i<n; i++){
            weights[i] = in.nextInt();
        }
        System.out.println(solve(weights));
    }

    private static int solve(int[] weights) {
        if(weights.length == 0)
            return 0;

        Arrays.sort(weights);
        int count = 1;
        int reach = weights[0] + 4;
        for(int i=1; i< weights.length; i++){
            if(weights[i] <= reach)
                continue;

            count++;
            reach = weights[i] + 4;
        }
        return count;
    }
}
