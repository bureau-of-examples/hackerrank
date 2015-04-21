package graphtheory.gridwalking;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/grid-walking
 */
public class TleSolution {

    private static final long modConstant = 1000000007L;
    private static final HashMap<BigInteger, Integer> cache = new HashMap<>();
    private static final BigInteger[] powers = new BigInteger[11];

    public static void main(String[] args) {

        powers[0] = BigInteger.ONE;
        for(int i=1; i<powers.length; i++){
            powers[i] = powers[i-1].multiply(BigInteger.valueOf(100L));
        }

        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for (int t = 0; t < numTestCase; t++) {
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();

            String[] parts = in.nextLine().split("\\s+");
            int[] pos = new int[n];
            int index = 0;
            for (String val : parts) {
                pos[index++] = Integer.valueOf(val);
            }

            parts = in.nextLine().split("\\s+");
            int[] dim = new int[n];
            index = 0;
            for (String val : parts) {
                dim[index++] = Integer.valueOf(val);
            }

            cache.clear();
            System.out.println(solveHashMap(null, n, m, pos, dim));
        }

    }

    //this one gets TLE
    private static int solveHashMap(BigInteger key, int n, int m, int[] pos, int[] dim) {
        if (m == 0)
            return 1;

        if(key == null){
            key = BigInteger.ZERO;
            for(int i=0; i<n; i++){
                key = key.add(BigInteger.valueOf(pos[i] - 1).multiply(powers[i]));
            }
            key = key.add(BigInteger.valueOf(m - 1).multiply(powers[10]));
        }

        if (cache.containsKey(key))
            return cache.get(key);

        long count = 0;//number of ways
        for (int i = 0; i < n; i++) {
            int posI = pos[i];
            //forward
            pos[i] = posI + 1;
            if (pos[i] <= dim[i]) {
                count += solveHashMap(key.subtract(powers[10]).add(powers[i]), n, m - 1, pos, dim);
                count %= modConstant;
            }
            //back
            pos[i] = posI - 1;
            if (pos[i] > 0) {
                count += solveHashMap(key.subtract(powers[10]).subtract(powers[i]), n, m - 1, pos, dim);
                count %= modConstant;
            }
            //restore
            pos[i] = posI;

        }

        cache.put(key, (int) count);
        return (int) count;
    }

}
