package warmup.servicelane;

import java.util.Scanner;

public class Solution {

    private static int largestVehicleType(int[] width, int entry, int exit){
        int largest = 3;
        for(int i=entry; i<=exit; i++){
            if(width[i] < largest){
                largest = width[i];
                if(largest == 1)
                    return 1;
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int[] width = new int[in.nextInt()];
        int numTestCase = in.nextInt();
        for(int i=0; i<width.length; i++){
            width[i] = in.nextInt();
        }

        for(int i=0; i<numTestCase; i++){
            int entry = in.nextInt();
            int exit = in.nextInt();
            System.out.println(largestVehicleType(width, entry, exit));
        }
    }

}