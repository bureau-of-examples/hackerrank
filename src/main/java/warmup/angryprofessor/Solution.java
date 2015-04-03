package warmup.angryprofessor;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/angry-professor
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = in.nextInt();

        for(int i=0; i<numTestCase; i++){
            in.nextLine();
            int n = in.nextInt();
            int k = in.nextInt();
            in.nextLine();
            int count = 0;
            for(int j=0; j<n; j++){
                int arrival = in.nextInt();
                if(arrival <= 0)
                    count++;
            }
            System.out.println(count < k ? "YES" : "NO");
        }
    }
}
