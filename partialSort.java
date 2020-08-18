import java.util.*;
import java.io.*;

public class partialSort
{
    
    public static void main (String[] args) {
        BufferedReader reader;
        
        // length of array
        int n;
        // array to be sorted
        int[] nums;
        // upper index of subarray to return
        int k;

        try {
            reader = new BufferedReader(new FileReader("rosalind_ps.txt"));
            
            // reads n
            String line = reader.readLine();
            n = Integer.parseInt(line);
    
            // reads numbers into array
            nums = new int[n];
            
            line = reader.readLine();
            String[] in = line.trim().split("\\s+");

            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(in[i]);
            }
            
            // reads k
            line = reader.readLine();
            k = Integer.parseInt(line);
                
            reader.close();
            
            // sorts array using selection sort
            
            for (int i = 0; i < n; i++) {

                // only sort through kth element
                if (i == k) {
                    System.out.println("");
                    break;
                }

                int lil = i;

                for (int j = 0 + i; j < n; j++) if (nums[j] < nums[lil]) lil = j;

                int temp = nums[i];
                nums[i] = nums[lil];
                nums[lil] = temp;
                
                System.out.print(nums[i] + " ");
            }
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}