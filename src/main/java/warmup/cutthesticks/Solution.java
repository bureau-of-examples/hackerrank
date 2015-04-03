package warmup.cutthesticks;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: johnz
 * Date: 27/03/15
 * Time: 4:53 PM
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numSticks = in.nextInt();
        int[] sticks = new int[numSticks];
        for(int i=0; i<numSticks; i++){
            sticks[i] = in.nextInt();
        }
        Arrays.sort(sticks);

        int index = 0;
        while (true){
            if(index == sticks.length)
                break;

            System.out.println(sticks.length - index);
            index++;
            while (index < sticks.length && sticks[index - 1] == sticks[index])  {
                index++;
            }
        }
    }
}
