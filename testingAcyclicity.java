import java.util.*;
import java.io.*;
import edu.princeton.cs.algs4.*;

public class testingAcyclicity
{
    
    public static void main (String[] args) 
    {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("test.txt"));
            String line = reader.readLine();
            // reads number of graphs
            int graphs = Integer.parseInt(line);
            
            for (int k = 0; k < graphs; k++) {
                
                // reads & ignores empty line
                line = reader.readLine();
                
                // reads in graph
                Digraph g = readGraph(reader);
                DirectedCycle c = new DirectedCycle(g);
                
                Boolean hasCycle = false;
                if (c.hasCycle()) hasCycle = true;
                
                System.out.print(hasCycle ? "1 " : "-1 ");
            } 
            reader.close();
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    private static Digraph readGraph (BufferedReader reader)
    {
        String line = reader.readLine();
        String[] nums = line.trim().split("\\s+");

        // number of verteces
        int v = Integer.parseInt(nums[0]);
        // number of edges
        int e = Integer.parseInt(nums[1]);
        
        Digraph g = new Digraph(v + 1);

        // reads edges into adjacency matrix
        for (int i = 0; i < e; i++) {

            line   = reader.readLine();
            nums   = line.trim().split("\\s+");

            g.addEdge(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
        }
        
        return g;
    }
}