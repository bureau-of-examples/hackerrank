package greedy.jimandtheorders;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/jim-and-the-orders
 */
public class Solution {

    private static class Fan implements Comparable<Fan>{
        public int index;
        public int finishTime;

        public Fan(int i, int f){
            this.index = i;
            this.finishTime = f;
        }

        @Override
        public int compareTo(Fan o) {
            return this.finishTime - o.finishTime;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Fan[] fans = new Fan[n];
        for(int i=0; i<n; i++){
            String[] str = in.nextLine().split("\\s+");
            fans[i] = new Fan(i + 1, Integer.parseInt(str[0]) + Integer.parseInt(str[1]));
        }
        Arrays.sort(fans);
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for(Fan fan : fans){
            if(first)
                first = false;
            else
                sb.append(" ");
            sb.append(fan.index);
        }
        System.out.println(sb.toString());
    }
}
