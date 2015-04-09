package search.icecreamparlor;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/icecream-parlor
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for(int i=0; i<numTestCase; i++){
            int m = Integer.parseInt(in.nextLine());
            int n = Integer.parseInt(in.nextLine());
            int[] flavors = new int[n];
            String[] values = in.nextLine().split("\\s+");
            for(int j=0; j<n; j++){
                flavors[j] = Integer.parseInt(values[j]);
            }

            solve(flavors, m);

        }
    }

    private static void solve(int[] flavors, int m) {
        HashMap<Integer, Integer> checkedFlavors = new HashMap<>();
        for(int i=0; i<flavors.length; i++){
            int flavor = flavors[i];
            Integer target = m - flavor;
            if(checkedFlavors.containsKey(target)){
                System.out.println(String.format("%d %d", checkedFlavors.get(target) + 1, i + 1));
                return;
            }
            if(!checkedFlavors.containsKey(flavor))
                checkedFlavors.put(flavor, i);
        }
    }
}
