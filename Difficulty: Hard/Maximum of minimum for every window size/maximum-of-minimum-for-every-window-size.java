//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Solution solution = new Solution();
            ArrayList<Integer> result = solution.maxOfMins(arr);
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends




class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];  // Stores previous smaller element index
        int[] right = new int[n]; // Stores next smaller element index
        int[] ans = new int[n + 1]; // Stores max of min for different window sizes

        Stack<Integer> stack = new Stack<>();

        // Compute Previous Smaller Element (PSE)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }

        // Clear stack for next computation
        stack.clear();

        // Compute Next Smaller Element (NSE)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = (stack.isEmpty()) ? n : stack.peek();
            stack.push(i);
        }

        // Compute max of min for different window sizes
        for (int i = 0; i < n; i++) {
            int windowSize = right[i] - left[i] - 1; // Window size in which arr[i] is the minimum
            ans[windowSize] = Math.max(ans[windowSize], arr[i]);
        }

        // Fill remaining values by propagating max from right to left
        for (int i = n - 1; i >= 1; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }

        // Convert ans[] to ArrayList
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(ans[i]);
        }

        return res;
    }
}
