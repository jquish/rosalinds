import java.util.*;
import java.io.*;

public class threeSum 
{
    private static class Map
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        public Map() {
            this.map = map;
        }
        
        // adds value to hashmap, with num[i] as the key and i as the value
        public void add(Integer value, Integer index) {
            
            if (!map.containsKey(value)) map.put(value, index);
        }
        
        // checks whether hashmap contains value -- returns index if so, else returns -1
        private int contains(Integer value) {
            
            if (map.containsKey(value)) return map.get(value);
            
            return -1;
        }
        
        public Boolean contains_pair(Integer total) {
            
            for (Integer value : map.keySet()) {
                
                int index = this.contains(total - value);
                
                if (index == map.get(value)) return false;
                
                if (index != -1) {
                    
                    if (index > map.get(value)) {
                        System.out.print(map.get(value) + " " + index + " ");
                    } else {
                        System.out.print(index + " " + map.get(value) + " ");
                    }
                    
                    return true;
                }
            }
            
            return false;
        }
    }
    
    public static void main(String[] args)
    {
        BufferedReader reader;
        try {
            reader          = new BufferedReader(new FileReader("rosalind_3sum.txt"));
            
            String line     = reader.readLine();
            String[] nums   = line.trim().split("\\s+");
            // number of arrays
            int output = Integer.parseInt(nums[0]);
            // length of each array
            int n = Integer.parseInt(nums[1]);
    
            for (int i = 0; i < output; i++) {
                
                // reads next line
                line = reader.readLine();
                // splits line into array of strings, where each string represents 1 integer
                nums = line.trim().split("\\s+");
                
                // initializes hashmap
                Map m = new Map();
                Boolean indeces_found = false;

                for (int j = 0; j < n; j++) {
                    
                    // if index has been found, waits until j is bumped up to print (not 0-based indeces)
                    if (indeces_found == true) {
                        System.out.println(j);
                        break;
                    }
                    
                    // parses current int
                    int temp = Integer.parseInt(nums[j]);
                    // calls function to check for corresponding pairs
                    indeces_found = m.contains_pair(-temp);
                    // adds int to hashmap
                    m.add(temp, j+1);
                }
                
                if (!indeces_found) System.out.println("-1");
            }
            
            reader.close();         
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}