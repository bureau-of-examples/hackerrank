package warmup.manasaandstones;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * https://www.hackerrank.com/challenges/manasa-and-stones
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = in.nextInt();
        for (int i = 0; i < numTestCase; i++) {
            in.nextLine();
            int n = in.nextInt();
            in.nextLine();
            int a = in.nextInt();
            in.nextLine();
            int b = in.nextInt();
            solve(n, a, b);
        }
    }

    private static void solve(int n, int a, int b) {
        HashSet<Integer> current = new HashSet<>();
        HashSet<Integer> next = new HashSet<>();
        current.add(a);
        current.add(b);

        for (int i = 2; i < n; i++) {
            for (Integer val : current) {
                next.add(val + a);
                next.add(val + b);
            }
            current.clear();
            HashSet<Integer> temp = next;
            next = current;
            current = temp;
        }


        TreeSet<Integer> sorted = new TreeSet<>(current);
        boolean first = true;
        for (Integer val : sorted) {
            if (first)
                first = false;
            else
                System.out.print(" ");
            System.out.print(val);
        }
        System.out.println();
    }
}
