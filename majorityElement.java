import java.util.*;
import java.io.*;

public class majorityElement 
{
    private static class Counter
    {
        HashMap<Integer, Integer> counter = new HashMap<>();
        
        public Counter() {
            this.counter = counter;
        }
        
        public void add(Integer i) {
            counter.merge(i, 1, Integer::sum);
        }
        
        public int count(Integer i) {
            return counter.getOrDefault(i, 0);
        }
    }
    
    public static void main(String[] args)
    {
        BufferedReader reader;
        try {
            reader          = new BufferedReader(new FileReader("rosalind_maj.txt"));
            
            String line     = reader.readLine();
            String[] nums   = line.trim().split("\\s+");
            // number of arrays
            int output = Integer.parseInt(nums[0]);
            // length of each array
            int n = Integer.parseInt(nums[1]);
    
            for (int i = 0; i < output; i++) {
                
                line = reader.readLine();
        
                // splits line into array of strings, where each string represents 1 integer
                nums = line.trim().split("\\s+");
                    
                Counter c = new Counter();
                Boolean maj_found = false;

                // parses through array and adds values to hashmap
                for (int j = 0; j < n; j++) {
                    int temp = Integer.parseInt(nums[j]);
                    c.add(temp);
                        
                    if (c.count(temp) > (n/2)) {
                        System.out.println(temp);
                        maj_found = true;
                        break;
                    }
                }
                
                if (!maj_found) System.out.println("-1");
            }
            
            reader.close();         
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}