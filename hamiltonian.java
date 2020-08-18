import edu.princeton.cs.algs4.*;

import java.util.Iterator;

public class hamiltonian {

    public static void main(String[] args) {

        In in = new In("rosalind_hdag.txt");
        int n = in.readInt();
        for (int i = 0; i < n ; i++) {
            Digraph g = readGraph(in);
            hasHamPath(g);
        }
    }

    private static Digraph readGraph(In in) {
        int v = in.readInt();
        int e = in.readInt();
        Digraph g = new Digraph(v+1);
        for (int i = 0; i < e ; i++) {
            g.addEdge(in.readInt(), in.readInt());
        }
        return g;
    }

    private static void hasHamPath(Digraph g){

        Topological t = new Topological(g);
        Iterator<Integer> order = t.order().iterator();

        if (order == null) {
            StdOut.println("-1 ");
            return;
        }


        int last = order.next();

        String s = "1 " + last + " ";

        while (order.hasNext()) {
            Integer o = order.next();

            if (o == last + 1 && o != 0 ){
                s += o;
                s += " ";

            } else if (o != 0) {
                StdOut.println("-1 ");
                return;
            }

            last = o;
        }
        StdOut.println(s);


    }
}