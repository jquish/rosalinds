import java.util.*;
import java.io.*;

public class countingInversions
{
    
    public static void main(String[] args)
    {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("rosalind_inv.txt"));
            
            String line = reader.readLine();
            
            // length of array
            int n = Integer.parseInt(line);
            // array
            int[] nums = new int[n];
            // inversion count
            int inversions = 0;
            
            line = reader.readLine();
            String[] in = line.trim().split("\\s+");
            
            // reads in numbers and populates array
            for (int i = 0; i < n; i++) {
            
                nums[i] = Integer.parseInt(in[i]);
        
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) inversions++;
                }
            } 
            reader.close(); 
            
            System.out.println(inversions);
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}