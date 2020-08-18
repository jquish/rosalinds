/* NOT WORKING */

import edu.princeton.cs.algs4.In;

import java.util.Stack;

public class semiConnectedGraph {

    public static void main(String[] args) {

        In in = new In("test.txt");

        int n = in.readInt();

        for (int i = 0; i < n; i++) {

            boolean[][] adjMatrix = readAdjMatrix(in);
            boolean semiConnected = true;

            for (int j = 0; j < adjMatrix.length; j++) {

                Stack<Integer> stack = new Stack<>();
                boolean[] found = new boolean[adjMatrix.length - 1];

                semiConnected = true;

                stack.push(j);

                while (!stack.empty()) {

                    int currentV = stack.pop();
                    System.out.println(currentV);

                    for (int k = 0; k < adjMatrix.length - 1; k++) {

                        if (adjMatrix[currentV][k+1] == false) {
                            continue;
                        } else {
                            if (!found[k]) {
                                found[k] = true;
                                stack.push(k);
                            }
                        }
                    }
                }

                if (containsFalse(found)) {
                    semiConnected = false;
                    break;
                }
            }

            System.out.print(semiConnected ? "1 " : "-1 ");
        }
    }

    private static boolean[][] readAdjMatrix(In in) {

        int v = in.readInt();
        int e = in.readInt();

        boolean[][] adjMatrix = new boolean[v+1][v+1];

        for (int i = 0; i < e; i++) {
            adjMatrix[in.readInt()][in.readInt()] = true;
        }

        return adjMatrix;
    }

    private static boolean containsFalse(boolean[] list) {

        for (boolean element : list) {
            if (!element) return false;
        }

        return true;
    }
}
