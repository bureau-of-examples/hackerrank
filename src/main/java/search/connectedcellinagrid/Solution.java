package search.connectedcellinagrid;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/connected-cell-in-a-grid
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = Integer.parseInt(in.nextLine());
        int n = Integer.parseInt(in.nextLine());
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            String str = in.nextLine();
            int index = 0;
            for (int j = 0; j < n; j++) {
                matrix[i][j] = str.charAt(index) - '0';
                index += 2;
            }
        }
        System.out.println(solve(matrix, m, n));
    }

    private static class Counter {
        private int value;
        private Counter override;

        public Counter(int val) {
            value = val;
            override = null;
        }

        private int getValue() {
            if (override != null)
                return override.value;

            return value;
        }

        private void addValue(int value) {
            if (override != null)
                override.value += value;
            else
                this.value += value;
        }

        public void increase() {
            if (this.override != null)
                override.value++;
            else
                this.value++;
        }

        private Counter getOverride() {
            return override;
        }

        public void setOverride(Counter override) {
            if (override.getOverride() == null)
                this.override = override;
            else
                this.override = override.getOverride();
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Counter){
                Counter other = (Counter)obj;
                if(this == other)
                    return true;
                if(this.override == other)
                    return true;
                if(this == other.override)
                    return true;
                if(this.override == other.override && this.override != null)
                    return true;
            }

            return false;
        }
    }

    private static int solve(int[][] matrix, int m, int n) {

        int max = 0;

        //populate top row
        Counter[] topRow = new Counter[n];
        Counter left = null;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0)
                continue;

            if (j > 0)
                left = topRow[j - 1];

            if (left == null)
                left = new Counter(0);

            topRow[j] = left;
            topRow[j].increase();
            max = Math.max(max, topRow[j].getValue());
        }

        for (int i = 1; i < m; i++) {
            left = null;
            for (int j = 0; j < n; j++) {

                //0 cell has no counter
                if(matrix[i][j] == 0){
                    if (j > 0) {
                        topRow[j - 1] = left;
                    }
                    left = null;
                    continue;
                }

                //get neighbours
                Counter topRight = null;
                if (j + 1 < n) {
                    topRight = topRow[j + 1];
                }
                Counter top = topRow[j];
                Counter topLeft = null;
                if (j > 0)
                    topLeft = topRow[j - 1];

                //calculate cell counter
                Counter counter;
                if (left != null) {

                    counter = left;
                    counter.increase();
                    if (topRight != null && !counter.equals(topRight)) {
                        counter.addValue(topRight.getValue());
                        topRight.setOverride(counter);
                    }
                } else {
                    if (topLeft != null) {
                        counter = topLeft;
                        counter.increase();
                        if (top == null && topRight != null && !counter.equals(topRight)) {
                            counter.addValue(topRight.getValue());
                            topRight.setOverride(counter);
                        }
                    } else {
                        if (top != null) {
                            counter = top;
                            counter.increase();
                        } else if (topRight != null) {
                            counter = topRight;
                            counter.increase();
                        } else {
                            counter = new Counter(1);
                        }
                    }
                }
                max = Math.max(max, counter.getValue());

                //update neighbour
                if (j > 0) {
                    topRow[j - 1] = left;
                }
                left = counter;
            }
            topRow[n - 1] = left;
        }

        return max;
    }

}
