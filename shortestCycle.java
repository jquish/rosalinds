import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class shortestCycle {

    public static void main(String[] args) {
        In in = new In("test.txt");
        int n = in.readInt();

        for (int i = 0; i < n ; i++) {

            int edge = 0;

            int v = in.readInt();
            int e = in.readInt();

            AdjMatrixEdgeWeightedDigraph g = new AdjMatrixEdgeWeightedDigraph(v + 1);

            for (int j = 0; j < e ; j++) {
                int v1 = in.readInt();
                int v2 = in.readInt();
                int weight = in.readInt();
                g.addEdge(new DirectedEdge(v1, v2, weight));

                System.out.println(v1+" "+v2+" "+weight);
                if (j == 0) edge = v1;
            }

            findCycleThroughEdge(g, edge);
        }

    }

    private static void findCycleThroughEdge(AdjMatrixEdgeWeightedDigraph g, int e){
        // use floyd warshall algorithm to get cycle
        FloydWarshall fw = new FloydWarshall(g);
        if(fw.hasNegativeCycle()){
            int length = 0;
            boolean seen = false;
            for (DirectedEdge i: fw.negativeCycle()) {
                length += i.weight();
                if (i.from() == e){
                    seen = true;
                }
            }

            // only return if we have seen the right edge
            if (seen) {
                StdOut.print(length + " ");
                return;
            }
        }
        StdOut.print("-1 ");
    }
}