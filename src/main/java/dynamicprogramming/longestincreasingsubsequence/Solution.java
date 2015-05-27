package dynamicprogramming.longestincreasingsubsequence;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/longest-increasing-subsequent
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(in.nextLine());
        }

        System.out.println(solve(sequence));
    }

    private static int solve(int[] sequence) {
        if (sequence.length == 0)
            return 0;

        List<Integer> minTail = new ArrayList<>(); //minTail[i] = min tail of all increasing sub-sequence of length i
        int longestLen = 1; //max length of all increasing sub-sequence
        minTail.add(0);//padding
        minTail.add(sequence[0]);

        for (int i = 1; i < sequence.length; i++) {
            //binary search in minTail - find the right most tail < sequence[i]
            int start = 0, end = minTail.size() - 1;
            while (start <= end) {
                int mid = (start + end) >>> 1;
                if (minTail.get(mid) >= sequence[i]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            int longestLenHere = end + 1;  //length of longest increasing sub-sequence ends at i
            if(longestLen < longestLenHere)
                longestLen = longestLenHere;

            if (longestLenHere >= minTail.size()) {
                minTail.add(sequence[i]);
            } else {
                if (sequence[i] < minTail.get(longestLenHere)) {
                    minTail.set(longestLenHere, sequence[i]);
                }
            }
        }

        return longestLen;
    }

    private static int solveTimeout(int[] sequence) {
        if (sequence.length == 0)
            return 0;

        int[] longestLenAt = new int[sequence.length];
        longestLenAt[0] = 1;

        for (int i = 1; i < sequence.length; i++) {
            longestLenAt[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (sequence[j] < sequence[i]) {
                    int newLen = longestLenAt[j] + 1;
                    if (longestLenAt[i] < newLen) {
                        longestLenAt[i] = newLen;
                    }
                }
            }
        }

        int max = 0;
        for (int len : longestLenAt) {
            if (len > max)
                max = len;
        }
        return max;
    }

    private static int solveTimeout2(int[] sequence) {
        if (sequence.length == 0)
            return 0;

        HashMap<Integer, Integer> longestLenAt = new HashMap<>();
        longestLenAt.put(0, 1);

        ArrayList<Integer> badKeys = new ArrayList<>();
        int max = 1;
        for (int i = 1; i < sequence.length; i++) {
            int longestLenHere = 1;

            for (Integer index : longestLenAt.keySet()) {
                if (sequence[index] < sequence[i]) {
                    int newLen = longestLenAt.get(index) + 1;
                    if (longestLenHere < newLen) {
                        longestLenHere = newLen;
                    }
                }
            }

            Iterator<Map.Entry<Integer, Integer>> iterator = longestLenAt.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (sequence[entry.getKey()] >= sequence[i] && entry.getValue() <= longestLenHere) {
                    iterator.remove();
                }
            }
            for (Integer index : badKeys) {
                longestLenAt.remove(index);
            }
            badKeys.clear();

            longestLenAt.put(i, longestLenHere);

            if (longestLenHere > max) {
                max = longestLenHere;
            }
        }


        return max;
    }
}
