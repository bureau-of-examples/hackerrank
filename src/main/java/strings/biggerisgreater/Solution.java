package strings.biggerisgreater;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/bigger-is-greater
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for(int i=0; i<numTestCase; i++){
            System.out.println(findBigger(in.nextLine()));
        }
    }

    private static String findBigger(String s) {
        char[] buffer = s.toCharArray();
        int index = buffer.length - 1;
        while (index > 0){
            if(buffer[index] > buffer[index - 1])
                break;
            index--;
        }
        if(index == 0)
            return "no answer";
        int swapIndex = biggerIndex(buffer, index, buffer.length - 1, buffer[index - 1]);
        char temp = buffer[index - 1];
        buffer[index - 1] = buffer[swapIndex];
        buffer[swapIndex] = temp;

        //reverse
        int start = index, end = buffer.length - 1;
        while (start < end){
            char ch = buffer[start];
            buffer[start] = buffer[end];
            buffer[end] = ch;
            start++;
            end--;
        }

        return new String(buffer);
    }

    private static int biggerIndex(char[] buffer, int start, int end, char target) {
        while (start <= end){                 //bin search in reverse order
           int mid = (start + end) >>> 1;
           if(buffer[mid] > target){
              start = mid + 1;
           } else {
              end = mid - 1;
           }
        }
        return end;
    }
}
