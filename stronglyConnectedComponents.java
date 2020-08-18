import edu.princeton.cs.algs4.*;

public class stronglyConnectedComponents {

    public static void main(String[] args) {

        In in = new In("rosalind_scc.txt");

        // number of vertices
        int v = in.readInt();
        // number of edges
        int e = in.readInt();

        Digraph g = new Digraph(v + 1);

        // reads and adds edges to Digraph
        for (int i = 0; i < e; i++) {
            g.addEdge(in.readInt(), in.readInt());
        }

        KosarajuSharirSCC k = new KosarajuSharirSCC(g);

        // calls Kosaraju-Sharir count() method which returns number of strongly connected components
        int count = k.count() - 1;

        // prints result
        StdOut.println(count);
    }
}