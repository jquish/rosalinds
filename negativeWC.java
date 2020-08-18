import edu.princeton.cs.algs4.BellmanFordSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.*;

public class negativeWC {

    public static void main(String[] args) {

        In in = new In("rosalind_nwc.txt");
        int reps = in.readInt();
        for (int i = 0; i < reps; i++) {

            int numNodes = in.readInt();
            int numEdges = in.readInt();

            EdgeWeightedDigraph fish = new EdgeWeightedDigraph(numNodes + 1);

            for (int e = 0; e < numEdges; e++) {
                DirectedEdge ed = new DirectedEdge(in.readInt(), in.readInt(), in.readInt());
                fish.addEdge(ed);
            }

            // run a Bellman Ford search on each node
            int found = -1;

            for (int j = 0; j < numNodes+1; j++) {
                BellmanFordSP s = new BellmanFordSP(fish, j);
                if (s.hasNegativeCycle()) {
                    found = 1;
                }
            }
            System.out.print(found + " ");
        }
    }
}