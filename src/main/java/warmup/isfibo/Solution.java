package warmup.isfibo;

import java.util.HashSet;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/is-fibo
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = in.nextInt();
        for(int i=0; i<numTestCase; i++){
            in.nextLine();
            long num = in.nextLong();
            System.out.println(isFibo(num) ? "IsFibo" : "IsNotFibo");
        }
    }

    private final static HashSet<Long> cache = new HashSet<Long>();
    private static long prev = 1;
    private static long current = 1;

    private static boolean isFibo(long num) {
        if(num < 0)
            return false;
        if(num <= 1)
            return true;
        if(cache.contains(num))
            return true;

        while (num > current){
            if(Long.MAX_VALUE - current < prev)
                break;//add overflow
            long next = prev + current;
            if(num == next)
                return true;
            prev = current;
            current = next;
            cache.add(current);
        }
        return false;
    }
}
