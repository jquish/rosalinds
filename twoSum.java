import java.util.*;
import java.io.*;

public class twoSum 
{
    private static class Map
    {
        /* maps int value to its index in array */
        HashMap<Integer, Integer> map = new HashMap<>();
        
        public Map() {
            this.map = map;
        }
        
        /* adds a value-index pair to hashmap only if hashmap doesn't already contain given value */
        public void add(Integer value, Integer index) {
            
            if (!map.containsKey(value)) map.put(value, index);
        }
        
        /* if hashmap contains value-index pair corresponding to passed value, returns index,
            else returns -1 */
        public int contains(Integer value) {
            
            if (map.containsKey(value)) return map.get(value);
            
            return -1;
        }
    }
    
    public static void main(String[] args)
    {
        BufferedReader reader;
        try {
            reader          = new BufferedReader(new FileReader("rosalind_2sum.txt"));
            
            String line     = reader.readLine();
            String[] nums   = line.trim().split("\\s+");
            // number of arrays
            int output = Integer.parseInt(nums[0]);
            // length of each array
            int n = Integer.parseInt(nums[1]);
    
            // for each array
            for (int i = 0; i < output; i++) {
                
                // reads next line from text file
                line = reader.readLine();
                // splits line into array of strings, where each string represents 1 integer
                nums = line.trim().split("\\s+");
                
                Map m = new Map(); // initializes hashmap
                Boolean indeces_found = false;

                /* reads each element into array, populating hashmap and 
                    performing inverse-index check with each pass */
                for (int j = 0; j < n; j++) {
                    
                    /* if index was found on pervious pass, print current j and break
                        (avoids printing 0-based indeces) */
                    if (indeces_found == true) {
                        System.out.println(j);
                        break;
                    }
                    
                    // reads current int
                    int temp = Integer.parseInt(nums[j]);
                    
                    // checks for corrensponding negative value in hashmap
                    int index = m.contains(-temp);
                  
                    // if corresponding index is found, print it out and set flag to true
                    if (index != -1) {
        
                        System.out.print(index + " ");
                        indeces_found = true;
                    }
                    
                    // adds current int to hashmap, mapping value to index
                    m.add(temp, j+1);
                    
                }
                
                // if index not found, print -1
                if (!indeces_found) System.out.println("-1");
            }
            
            reader.close();         
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}