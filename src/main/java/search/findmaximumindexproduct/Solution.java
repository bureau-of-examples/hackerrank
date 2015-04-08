package search.findmaximumindexproduct;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/find-maximum-index-product
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        if (n <= 2)
            System.out.println("0");
        else
            System.out.println(solve(array));

    }

    private static long solve(int[] array) {
        int[] buffer = new int[array.length * 2];

        //calc left
        int[] left = new int[array.length];
        int start = 0, end = 0;//buffer = index1,value1 | index2, value2 | index3, value3 | ... pointing to lower element
        for (int i = 0; i < array.length; i++) {
            if (end > start && array[i] < buffer[end - 1]) {
                left[i] = buffer[end - 2] + 1;
            } else {
                //binary search left[i]
                int l = start, r = end - 2;//inclusive start and end
                while (l <= r) {
                    int mid = l + (r - l) / 2 / 2 * 2;
                    if (buffer[mid + 1] <= array[i]) {
                        r = mid - 2;
                    } else {
                        l = mid + 2;
                    }
                }
                left[i] = r < 0 ? 0 : buffer[r] + 1;
                end = left[i] << 1;
            }
            buffer[end++] = i;
            buffer[end++] = array[i];
        }

        //calc right
        int[] right = new int[array.length];
        end = start = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (end > start && array[i] < buffer[end - 1]) {
                right[i] = buffer[end - 2] + 1;
            } else {
                //binary search right[i]
                int l = start, r = end - 2;//inclusive start and end
                while (l <= r) {
                    int mid = l + (r - l) / 2 / 2 * 2;
                    if (buffer[mid + 1] <= array[i]) {
                        r = mid - 2;
                    } else {
                        l = mid + 2;
                    }
                }
                right[i] = r < 0 ? 0 : buffer[r] + 1;
                if (right[i] == 0)
                    end = 0;
                else
                    end = (array.length - right[i] + 1) * 2;

            }
            buffer[end++] = i;
            buffer[end++] = array[i];
        }

        //output biggest product
        long max = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            long product = (long) left[i] * right[i];
            if (product > max)
                max = product;
        }
        return max;
    }
}
