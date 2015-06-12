package dynamicprogramming.equal;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Timed out bad : (
 */
public class DFSSolution {

    private static class Distribution {

        private int size;
        private int[] values;

        public Distribution(int n, String line) {

            size = n;
            values = new int[n];
            String[] items = line.split("\\s+");
            for (int i = 0; i < n; i++) {
                values[i] = Integer.parseInt(items[i]);
            }
        }

        private Distribution() {

        }

        public int getSize() {
            return size;
        }

        public boolean isEqual() {
            for (int i = 1; i < values.length; i++) {
                if (values[i] != values[i - 1])
                    return false;
            }
            return true;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (!(obj instanceof Distribution)) {
                return false;
            }

            Distribution other = (Distribution) obj;
            for (int i = 0; i < getSize(); i++) {
                if (this.values[i] != other.values[i])
                    return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            int hashCode = 0;
            for (int i = 0; i < getSize(); i += 2) {
                hashCode ^= this.values[i];
            }
            return hashCode;
        }

        public Distribution clone() {
            Distribution distribution = new Distribution();
            distribution.size = this.size;
            distribution.values = Arrays.copyOf(this.values, this.values.length);
            return distribution;
        }

        public void operate(int excludedIndex, int val) {
            for (int i = 0; i < values.length; i++) {
                if (i != excludedIndex)
                    values[i] += val;
            }
        }

        public boolean isFeasible(int index){
            int min = values[0];
            for(int i=1; i<values.length; i++)
                if(values[i] < min)
                    min = values[i];

            return values[index] != min;

        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for (int t = 0; t < numTestCase; t++) {
            int n = Integer.parseInt(in.nextLine());

            System.out.println(solve(new Distribution(n, in.nextLine())));
        }
    }

    private static int minOperations;

    private static int solve(Distribution distribution) {
        minOperations = Integer.MAX_VALUE;
        solve(distribution, 0);
        return minOperations;
    }

    private static final int[] STEP = {1, 2, 5};

    private static void solve(Distribution distribution, int operationsAlreadyTook) {
        if (distribution.isEqual()) {
            if (operationsAlreadyTook < minOperations) {
                minOperations = operationsAlreadyTook;
            }
            return;
        }

        operationsAlreadyTook++;
        if (operationsAlreadyTook >= minOperations) {
            return;
        }

        for (int i = 0; i < distribution.getSize(); i++) {

            for (int j = 0; j < STEP.length; j++) {
                if(distribution.isFeasible(i)){
                    distribution.operate(i, STEP[j]);
                    solve(distribution, operationsAlreadyTook);
                    distribution.operate(i, -STEP[j]);
                }
            }
        }
    }

}
