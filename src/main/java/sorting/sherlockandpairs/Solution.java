package sorting.sherlockandpairs;

import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-pairs
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for(int t = 0; t<numTestCase; t++){
            in.nextLine();
            HashMap<Integer, Integer> map = new HashMap<>();
            for(String str : in.nextLine().split("\\s+")){
                 Integer val = Integer.valueOf(str);
                Integer count = map.get(val);
                if(count == null)
                    count = 1;
                else
                    count++;
                map.put(val, count);
            }

            long total = 0;
            for(Integer k : map.keySet()){
                Integer count = map.get(k);
                if(count > 1){
                    total += (long)count * (count - 1);
                }
            }
            System.out.println(total);
        }
    }
}
