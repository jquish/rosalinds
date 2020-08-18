import java.util.*;
import java.io.*;

public class median {
    
    public static void main (String[] args) {
        BufferedReader reader;
        
        // length of array
        int n;
        // array to be sorted
        int[] nums;
        // (sorted) index of element to return
        int k;

        try {
            reader = new BufferedReader(new FileReader("rosalind_med.txt"));
            
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
            
            if (k < n/2) {
                // k is in smaller half of array, sort from smallest to largest
                for (int i = 0; i < n; i++) {

                    // only sort through kth element
                    if (i == k) {
                        System.out.println(nums[k-1]);
                        break;
                    }

                    int lil = i;

                    for (int j = 0 + i; j < n; j++) if (nums[j] < nums[lil]) lil = j;

                    int temp = nums[i];
                    nums[i] = nums[lil];
                    nums[lil] = temp;
                }
            } else {
                // k is in larger half of array, sort from largest
                for (int i = 0; i < n; i++) {

                    // only sort through n - kth element
                    if (i == n - k + 1) {
                        System.out.println(nums[n - k]);
                        break;
                    }

                    int big = i;

                    for (int j = 0 + i; j < n; j++) if (nums[j] > nums[big]) big = j;

                    int temp = nums[i];
                    nums[i] = nums[big];
                    nums[big] = temp;
                }
            }
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}