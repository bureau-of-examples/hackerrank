package combinatorics.connectingtowns;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/connecting-towns
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for (int t = 0; t < numTestCase; t++) {
            int n = Integer.parseInt(in.nextLine());
            int result = 1;
            for(int i=0; i<n - 1;i++){
                result = (result * in.nextInt()) % 1234567;
            }
            System.out.println(result);
            if(in.hasNextLine())
                in.nextLine();
        }
    }
}
