package warmup.maxmin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/angry-children
 */
public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int K = Integer.parseInt(in.readLine());
        int[] list = new int[N];

        for(int i = 0; i < N; i ++)
            list[i] = Integer.parseInt(in.readLine());

        int unfairness = maxMin(list, K);

        System.out.println(unfairness);
    }

    private static int maxMin(int[] list, int k) {
        Arrays.sort(list);
        int start = 0; int end = k-1;
        int min = list[end] - list[start];
        start++; end++;
        while (end < list.length){
            int newMin =  list[end] - list[start];
            if(newMin < min)
                min = newMin;
            start++; end++;
        }
        return min;
    }
}
