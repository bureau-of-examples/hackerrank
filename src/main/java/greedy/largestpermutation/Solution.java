package greedy.largestpermutation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/largest-permutation
 */
public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split("\\s+");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }

        solveFast(num, k);

        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int v : num) {
            if (first)
                first = false;
            else
                sb.append(' ');

            sb.append(v);
        }
        System.out.println(sb.toString());

    }


    public static void solveFast(int[] num, int k) {
        int n = num.length;
        int[] idx = new int[n + 1];
        for(int i=0; i<n; i++){
            idx[num[i]] = i;
        }
        int swapCount = 0;
        for (int i = 0; i < n && swapCount < k; i++) {

            int val = n - i; //value should be here at i
            if(num[i] == val)
                continue;
            int temp = num[i];
            num[i] = val;
            int j = idx[val];
            num[j] = temp;
            idx[val] = i;
            idx[temp] = j;
            swapCount++;
        }
    }

    //this slow solution works when there are duplicate numbers in the array
    //however the problem description states the n elements will be in the range of [1, n]
    private static void solve(int[] num, int k) {
        int swapCount = 0;
        for (int i = 0; i < num.length; i++) {
            if (swapCount == k)
                break;
            int max = num[i];
            int maxIndex = i;
            for (int j = i + 1; j < num.length; j++) {
                if (num[j] > max) {
                    max = num[j];
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                swapCount++;
                int temp = num[i];
                num[i] = num[maxIndex];
                num[maxIndex] = temp;
            }
        }
    }
}
