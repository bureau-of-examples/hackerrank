package geometry.findpoint;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/find-point
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for(int t=0; t<numTestCase; t++){
            String[] coordinates = in.nextLine().split("\\s+");
            int px = Integer.parseInt(coordinates[0]);
            int py = Integer.parseInt(coordinates[1]);
            int qx = Integer.parseInt(coordinates[2]);
            int qy = Integer.parseInt(coordinates[3]);

            System.out.println((qx - (px - qx)) + " " + (qy - (py - qy)));
        }
    }
}
