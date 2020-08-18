import java.util.*;
import java.io.*;

public class testingBipartiteness
{
    
    public static void main (String[] args) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("rosalind_bip.txt"));
            
            String line = reader.readLine();
            int graphs = Integer.parseInt(line); // reads total number of graphs
            
            // for each graph
            for (int k = 0; k < graphs; k++) {
                
                line = reader.readLine(); // reads & ignores empty line
                
                // reads nums in as string, splits into array on whitespace
                line = reader.readLine(); 
                String[] nums = line.trim().split("\\s+");
                
                // number of verteces
                int v = Integer.parseInt(nums[0]);
                // number of edges
                int e = Integer.parseInt(nums[1]);
            
                // new adjacency matrix (adjusted because vertices start at 1)
                Boolean[][] neighbors = new Boolean[v+1][v+1];
                
                // reads edges into adjacency matrix
                for (int i = 0; i < e; i++) {
                
                    line   = reader.readLine();
                    nums   = line.trim().split("\\s+");
            
                    int v1 = Integer.parseInt(nums[0]);
                    int v2 = Integer.parseInt(nums[1]);
                
                    // each vertex is marked as a neighbor of the other
                    neighbors[v1][v2] = true;
                    neighbors[v2][v1] = true;
                }
                
                // new stack to be used for DFS of neighbors
                Stack<Integer> stack = new Stack<Integer>();
                
                // array to store color of each vertex, represented as 0 or 1 (null if vertex isn't colored)
                Integer[] colors = new Integer[v+1];
            
                Boolean bipartite = true;
                
                // arbitrarily sets color of first vertex and pushes onto stack
                colors[1] = 0;
                stack.push(1);
                
                while(!stack.empty()) {
                    
                    // pops vertex
                    int currentV = stack.pop();
                    
                    // iterates through vertex's neighbors list
                    for (int i = 1; i <= v; i++) {
                    
                        // skip index if not a neighbor
                        if (neighbors[currentV][i] == null) continue;
                        
                        // if adjacent verteces of same color, bipartiteness disproven, adjust flag break
                        } else if (colors[currentV] == colors[i]) {
                            bipartite = false;
                            break;
                            
                        // if neighbor not colored yet, color opposite to current vertex
                        } else if (colors[i] == null) {
                            colors[i] = (colors[current_v] == 1) ? 0 : 1;
                        }
                        
                        /* if neighbor hasn't already been visited, push onto stack --
                            corresponding 0-index in adjacency matrix is used as a visited array */
                        if (neighbors[i][0] == null) stack.push(i);
                    }
                    
                    // check flag, break if bipartiteness disproven
                    if (bipartite == false) break;
                    
                    // mark current vertex as visited by setting corresponding 0-index in adjaceny matrix to 1
                    neighbors[currentV][0] = true;
                }
                
                // print 1 if bipartite graph, else print -1
                if (bipartite == false) System.out.print("-1 ");
                else System.out.print("1 ");
            } 
            reader.close();
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}