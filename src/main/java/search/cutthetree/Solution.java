package search.cutthetree;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/cut-the-tree
 */
public class Solution {

    private static class Node implements Comparable<Node> {
        public int weight;
        public Map<Node, Integer> weightSumWithout = new TreeMap<>();

        public Node(int w) {
            weight = w;
        }

        public int getWeightSumWithout(Node excludedNeighbour) {
            if (!weightSumWithout.containsKey(excludedNeighbour))
                throw new RuntimeException("That's not my neighbour.");

            Integer sum = weightSumWithout.get(excludedNeighbour);
            if (sum != null) {
                return sum;
            }

            int intSum = this.weight;
            for (Node neighbour : weightSumWithout.keySet()) {
                if (neighbour != excludedNeighbour) {
                    intSum += neighbour.getWeightSumWithout(this);
                }
            }
            weightSumWithout.put(excludedNeighbour, intSum);
            return intSum;
        }

        @Override
        public int compareTo(Node o) {
            return this.hashCode() - o.hashCode();
        }
    }

    private static class Edge {
        public Node node1;
        public Node node2;

        public Edge(Node n1, Node n2) {
            node1 = n1;
            node2 = n2;
            node1.weightSumWithout.put(node2, null);
            node2.weightSumWithout.put(node1, null);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(in.nextInt());
        }
        in.nextLine();
        Edge[] edges = new Edge[n - 1];
        for (int i = 0; i < edges.length; i++) {
            String[] indices = in.nextLine().split("\\s+");
            edges[i] = new Edge(nodes[Integer.parseInt(indices[0]) - 1], nodes[Integer.parseInt(indices[1]) - 1]);
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            int diff = Math.abs(edges[i].node1.getWeightSumWithout(edges[i].node2) - edges[i].node2.getWeightSumWithout(edges[i].node1));
            if (diff < minDiff)
                minDiff = diff;
        }
        System.out.println(minDiff);

    }
}
