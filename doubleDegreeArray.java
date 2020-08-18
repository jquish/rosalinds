import java.io.*;
import java.util.*;

public class doubleDegreeArray 
{   
    public static void main (String[] args) 
    {
        int[][] edges;
        int[] sums;
        int n = 0;
        
        BufferedReader reader; 
        try {
            reader = new BufferedReader(new FileReader("rosalind_ddeg.txt"));
            String line     = reader.readLine();
            String[] nums   = line.trim().split("\\s+");
            
            n = Integer.parseInt(nums[0]);
            // edge[x][0] stores neighbor count for x
            edges   = new int[n][n + 1];
            sums    = new int[n];
            
            line = reader.readLine();
            while (line != null) {
                nums = line.trim().split("\\s+");
                int first   = Integer.parseInt(nums[0]);
                int sec     = Integer.parseInt(nums[1]);
          
                // populates edges array with nieghbors
                edges[first - 1][sec] = 1;
                edges[sec - 1][first] = 1;
                
                edges[first - 1][0]++;
                edges[sec - 1][0]++;
                
                line = reader.readLine();
            }
            reader.close(); 
            
            // populates sum array with sum of neighbor degrees
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 1; j <= n; j++) {
                    if (edges[i][j] == 1) sum += edges[j - 1][0];
                }
                System.out.print(sum + " ");
            }
            System.out.print("\n");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}