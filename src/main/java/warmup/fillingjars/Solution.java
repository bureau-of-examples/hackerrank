package warmup.fillingjars;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/filling-jars
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long total = 0;
        for(int i=0; i< m; i++){
            in.nextLine();
            long a = in.nextInt();
            long b = in.nextInt();
            long k = in.nextInt();
            total += (b-a+1)*k;
        }
        System.out.println(total / n);
    }
}
