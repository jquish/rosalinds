import java.io.*;

public class squareInGraph
{
    private static void printMatrix (int[][] matrix) {

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
    }

    private static int[][] matMultiplySelf(int[][] matrix) {

        int res[][] = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix.length; k++) {

                    res[i][j] += matrix[i][k] * matrix[k][j];
                }
            }
        }

        return res;
    }

    public static void main (String[] args) {

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("rosalind_sq.txt"));
            String line = reader.readLine();

            // reads number of graphs
            int graphs = Integer.parseInt(line);

            for (int k = 0; k < graphs; k++) {

                line = reader.readLine(); // reads & ignores empty line

                line = reader.readLine();
                String[] nums = line.trim().split("\\s+");

                // number of vertices
                int v = Integer.parseInt(nums[0]);
                // number of edges
                int e = Integer.parseInt(nums[1]);

                // new adjacency matrix
                int[][] adjMatrix = new int[v + 1][v + 1];

                // reads edges into adjacency matrix
                for (int i = 0; i < e; i++) {

                    line = reader.readLine();
                    nums = line.trim().split("\\s+");

                    int v1 = Integer.parseInt(nums[0]);
                    int v2 = Integer.parseInt(nums[1]);

                    adjMatrix[v1][v2] = 1;
                    adjMatrix[v2][v1] = 1;
                }

                adjMatrix = matMultiplySelf(adjMatrix);

                boolean squareFound = false;

                for (int i = 1; i < adjMatrix.length; i++) {
                    for (int j = 1; j < adjMatrix.length; j++) {

                        if (i != j && adjMatrix[i][j] > 1) {
                            squareFound = true;
                            break;
                        }
                    }

                    if (squareFound) break;
                }

                System.out.print(squareFound ? "1 " : "-1 ");
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
