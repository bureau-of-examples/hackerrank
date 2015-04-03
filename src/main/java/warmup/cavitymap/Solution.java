package warmup.cavitymap;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/cavity-map
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        char[][] mat = new char[n][];
        for(int i=0; i<n; i++){
            String line = in.nextLine();
            mat[i] = line.toCharArray();
        }

        for(int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if(i == 0 || i == n - 1 || j == 0 || j == n - 1)
                    System.out.print(Character.valueOf((char)(mat[i][j])));
                else {
                    if(   mat[i][j] > mat[i-1][j]
                       && mat[i][j] > mat[i][j-1] && mat[i][j] > mat[i][j+1]
                       && mat[i][j] > mat[i+1][j]) {
                        System.out.print('X');
                    } else {
                        System.out.print(mat[i][j]);
                    }
                }

            }
            System.out.println();
        }
    }
}
