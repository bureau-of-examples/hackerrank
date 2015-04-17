package graphtheory.rustmurderer;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/rust-murderer
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for (int t = 0; t < numTestCase; t++) {
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();
            HashSet<Long> edges = new HashSet<>();
            for (int i = 0; i < m; i++) {
                int s = in.nextInt() - 1;
                int e = in.nextInt() - 1;
                in.nextLine();
                if (s > e) {
                    int temp = s;
                    s = e;
                    e = temp;
                }
                edges.add(((long) s) << 32 | 0xFFFFFFFFL & e);
            }
            int start = Integer.parseInt(in.nextLine()) - 1;
            int[] dist = solve(edges, n, start);
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (int i = 0; i < n; i++) {
                if (i != start) {
                    if (first)
                        first = false;
                    else
                        sb.append(' ');
                    sb.append(dist[i]);
                }
            }
            System.out.println(sb.toString());
        }
    }

    private static int[] solve(HashSet<Long> edges, int n, int start) {   //breath first search
        final int[] dist = new int[n];
        Arrays.fill(dist, -1); //use as infinity
        boolean[] visited = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0; //assume graph is connected
        visited[start] = true;
        int visitedCount = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0; i < n; i++) {
                if (!visited[i] && !(i < node ? edges.contains(((long) i) << 32 | 0xFFFFFFFFL & node) : edges.contains(((long) node) << 32 | 0xFFFFFFFFL & i))) {
                    dist[i] = dist[node] + 1;
                    visited[i] = true;
                    visitedCount++;
                    queue.add(i);
                }
            }
            if (visitedCount == n)
                break;
        }
        return dist;
    }

}
