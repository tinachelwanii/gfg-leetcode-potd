//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String str[] = br.readLine().split(" ");
            int arr[] = new int[str.length];

            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            Solution obj = new Solution();

            obj.reverseArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    public void reverseArray(int arr[]) {
        int first = 0, last = arr.length - 1;
        
        while (first < last) {
            int temp = arr[last];
            arr[last] = arr[first];
            arr[first] = temp;
            
            first++;
            last--;
        }
    }

    public static void main(String args[]) {
        int arr[] = {1, 4, 3, 2, 6, 5}; // Correct array initialization syntax
        Solution solution = new Solution(); // Create an object of the Solution class
        solution.reverseArray(arr); // Call the method using the object
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); // Use print() instead of println() for space-separated output
        }
        System.out.println(); // Add a newline after the loop
    }
}
