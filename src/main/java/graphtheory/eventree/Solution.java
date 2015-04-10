package graphtheory.eventree;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/even-tree
 */
public class Solution {

    private static class Node implements Comparable<Node> {
        public Set<Node> neighbours = new TreeSet<>();

        @Override
        public int compareTo(Node o) {
            return this.hashCode() - o.hashCode();
        }

        public int getExcludeCount(Node node) {

            int c = 1;
            for (Node n : neighbours) {
                if (n != node) {
                    c += n.getExcludeCount(this);
                }
            }
            return c;
        }
    }

    private static class Edge {
        public int node1;
        public int node2;

        public Edge(int n1, int n2) {
            node1 = n1;
            node2 = n2;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            String[] values = in.nextLine().split("\\s+");
            int node1 = Integer.parseInt(values[0]) - 1;
            int node2 = Integer.parseInt(values[1]) - 1;
            nodes[node1].neighbours.add(nodes[node2]);
            nodes[node2].neighbours.add(nodes[node1]);
            edges[i] = new Edge(node1, node2);
        }

        int removableCount = 0;
        for (int i = 0; i < m; i++) {
            int n1 = edges[i].node1;
            int n2 = edges[i].node2;
            if (nodes[n1].getExcludeCount(nodes[n2]) % 2 == 0 && nodes[n2].getExcludeCount(nodes[n1]) % 2 == 0) {
                removableCount++;
                nodes[n1].neighbours.remove(nodes[n2]);
                nodes[n2].neighbours.remove(nodes[n1]);
            }

        }
        System.out.println(removableCount);
    }
}
