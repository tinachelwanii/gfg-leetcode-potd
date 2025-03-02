//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] a = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                a[i] = Integer.parseInt(numsStr[i]);
            }
            line = read.readLine().trim();
            numsStr = line.split(" ");
            int[] b = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                b[i] = Integer.parseInt(numsStr[i]);
            }
            Solution ob = new Solution();
            if (ob.isSubset(a, b))
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends
class Solution {
    public boolean isSubset(int a[], int b[]) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        
        // Store frequencies of elements in 'a'
        for (int num : a) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Check each element in 'b' against 'a'
        for (int num : b) {
            if (!freqMap.containsKey(num) || freqMap.get(num) == 0) {
                return false; // Element not found or exhausted in 'a'
            }
            freqMap.put(num, freqMap.get(num) - 1); // Reduce count
        }

        return true; // All elements of 'b' found in 'a'
    }
}
