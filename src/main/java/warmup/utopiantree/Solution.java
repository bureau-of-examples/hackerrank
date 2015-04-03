package warmup.utopiantree;

import java.util.*;

public class Solution {

    static int treeCycle(int cycle) {
        int height = 1;
        for(int i=0; i<cycle; i++){
            height += (i & 1) == 0 ? height : 1;
        }
        return height;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0;i<t;i++) {
            int cycle = in.nextInt();
            System.out.println(treeCycle(cycle));
        }
    }
}
