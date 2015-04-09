package search.countluck;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/count-luck
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for (int t = 0; t < numTestCase; t++) {
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();
            char[][] matrix = new char[n][];
            for (int i = 0; i < n; i++) {
                matrix[i] = in.nextLine().toCharArray();
            }
            int k = Integer.parseInt(in.nextLine());
            System.out.println(solve(matrix, n, m, k) ? "Impressed" : "Oops!");

        }
    }

    private static class Node {

        public int i, j, c;

        public Node(int i, int j, int count) {
            this.i = i;
            this.j = j;
            this.c = count; //how many branches to reach here
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Node) {
                Node other = (Node) obj;
                return i == other.i && j == other.j;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return i * 100 + j;
        }

    }

    private static boolean solve(char[][] matrix, int n, int m, int k) {
        //find start position
        int hRow = 0, hCol = 0;
        for (int i = 0; i < n; i++) {
            boolean b = false;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 'M') {
                    hRow = i;
                    hCol = j;
                    b = true;
                    break;
                }
            }
            if (b)
                break;
        }

        //breath first search in tree
        Stack<Node> level = new Stack<>();
        HashSet<Node> visited = new HashSet<>();
        level.push(new Node(hRow, hCol, 0));
        ArrayList<Node> descendants = new ArrayList<>();

        do {
            Node node = level.pop();
            visited.add(node);
            //find descendants
            int i = node.i;
            int j = node.j;
            if (i > 0 && matrix[i - 1][j] != 'X') {
                Node child = new Node(i - 1, j, node.c);
                if (!visited.contains(child))
                    descendants.add(child);
            }

            if (j < m - 1 && matrix[i][j + 1] != 'X') {
                Node child = new Node(i, j + 1, node.c);
                if (!visited.contains(child))
                    descendants.add(child);
            }

            if (i < n - 1 && matrix[i + 1][j] != 'X') {
                Node child = new Node(i + 1, j, node.c);
                if (!visited.contains(child))
                    descendants.add(child);
            }

            if (j > 0 && matrix[i][j - 1] != 'X') {
                Node child = new Node(i, j - 1, node.c);
                if (!visited.contains(child))
                    descendants.add(child);
            }

            boolean branched = descendants.size() > 1;
            for (Node child : descendants) {
                if (branched)
                    child.c++;
                if (matrix[child.i][child.j] == '*')
                    return child.c == k;
                level.push(child);
            }

            descendants.clear();

        } while (!level.isEmpty());
        return false;
    }
}
