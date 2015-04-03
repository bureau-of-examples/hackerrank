package warmup.acmicpcteam;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/acm-icpc-team
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        char[][] matrix = new char[n][];
        for(int i=0; i<n ;i++){
            matrix[i] = in.nextLine().toCharArray();
        }
        solve(matrix, m);
    }

    private static void solve(char[][] matrix, int m) {
        int maxBitCount = 0;
        int maxTeam = 0;
        for(int i=0; i< matrix.length; i++){
            for(int j=i+1; j<matrix.length; j++){
                int bitCount = 0;
                for(int k=0; k<m; k++){
                    if(matrix[i][k] == '1' || matrix[j][k] == '1')
                        bitCount++;
                }
                if(bitCount > maxBitCount){
                    maxBitCount = bitCount;
                    maxTeam = 1;
                } else if(bitCount == maxBitCount){
                    maxTeam++;
                }
            }
        }
        System.out.println(maxBitCount);
        System.out.println(maxTeam);
    }

}
