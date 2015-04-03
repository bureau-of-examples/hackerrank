package warmup.sherlockandthebeast;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-the-beast
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = in.nextInt();
        for(int i=0; i<numTestCase; i++){
            in.nextLine();
            int n = in.nextInt();
            solve(n);
        }
    }

    private static void solve(int n) {
        int a = n;
        boolean cool = false;
        while (a >= 0){
            if(a % 3 != 0){
                a-=5;  //from t threes to t + 5 threes
            } else  {
               cool = true;
               break;
            }
        }
        if(!cool)
            System.out.println(-1);
        else{
            output(a, n-a);
        }
    }

    private static void output(int times, int times2){
        StringBuilder sb = new StringBuilder(); //don't.. directly output to STDOUT as it is very slow
        for(int i=0; i<times; i++){
            sb.append('5');
        }
        for(int i=0; i<times2; i++){
            sb.append('3');
        }
        System.out.println(sb.toString());
    }

}
