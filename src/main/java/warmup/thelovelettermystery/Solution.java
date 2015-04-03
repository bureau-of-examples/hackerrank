package warmup.thelovelettermystery;


import java.util.Scanner;

public class Solution {

    private static int opCount(String word){
        int count = 0;
        int start = 0, end = word.length() - 1;
        while (start < end){
            char ch1 = word.charAt(start);
            char ch2 = word.charAt(end);
            count += ch1 > ch2 ? ch1 - ch2 : ch2 - ch1;
            start++; end--;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = in.nextInt();
        in.nextLine();
        for(int i=0; i<numTestCase;i++){
            System.out.println(opCount(in.nextLine()));
        }
    }
}
