package search.thegridsearch;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-grid-search
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for(int t = 0; t<numTestCase; t++){
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();
            String[] src = new String[n];
            for(int i=0; i<n;i++){
                src[i] = in.nextLine();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            in.nextLine();
            String[] pat = new String[r];
            for(int i=0; i<r; i++){
                pat[i] = in.nextLine();
            }
            System.out.println(solve(src, n, m, pat, r, c) ? "YES" : "NO");

        }
    }

    private static boolean solve(String[] src, int n, int m, String[] pat, int r, int c) {

        int endRow = n - r;
        int index = -1;
        for(int i=0; i<= endRow; i++){
            while (true){
                index = src[i].indexOf(pat[0], index + 1);
                if(index == -1)
                    break;

                if(match(src, i, index, pat, r, c))
                    return true;
            }
            index = -1;
        }
        return false;
    }

    private static boolean match(String[] src, int i, int index, String[] pat, int r, int c) {
        for(int row = 1; row < r; row++){
            for(int col = 0; col<c; col++){
                if(src[i + row].charAt(index + col) != pat[row].charAt(col))
                    return false;
            }
        }
        return true;
    }
}
