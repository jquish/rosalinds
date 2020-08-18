import java.util.*;
import java.io.*;

public class connectedComponents 
{
    
    public static void main(String[] args)
    {
        BufferedReader reader;
        try {
            reader          = new BufferedReader(new FileReader("rosalind_cc.txt"));
            
            String line     = reader.readLine();
            String[] nums   = line.trim().split("\\s+");
            
            // number of vertices
            int v = Integer.parseInt(nums[0]);
            // number of edges
            int e = Integer.parseInt(nums[1]);
        
            // adjacency matrix
            int[][] neighbors = new int[v+1][v+1];
            
            // reads in edges and populates adjacency matrix
            for (int i = 0; i < e; i++) {
                
                line   = reader.readLine();
                nums   = line.trim().split("\\s+");
            
                int v1 = Integer.parseInt(nums[0]);
                int v2 = Integer.parseInt(nums[1]);
                
                neighbors[v1][v2] = 1;
                neighbors[v2][v1] = 1;
            }
            
            // counter to track number of connected graph components
            int components = 0;
            
            for (int i = 1; i <= v; i++) {
                
                // skips if vertex has already been searched
                if (neighbors[i][0] == 1) continue;
                
                components++;
                // initializes stack for depth-first search of current component
                Stack<Integer> stack = new Stack<Integer>();
                
                stack.push(i);

                while (!stack.empty()) {

                    int current_v = stack.pop();

                    for (int j = 1; j <= v; j++) {

                        // skip if not a neighbor
                        if (neighbors[current_v][j] != 1) continue;

                        // if neighbor hasn't been searched, push to stack
                        if (neighbors[j][0] != 1) stack.push(j);
                    }

                    // mark current vertex as searched
                    neighbors[current_v][0] = 1;
                }
            }
            
            System.out.println(components);
            
            reader.close();         
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}