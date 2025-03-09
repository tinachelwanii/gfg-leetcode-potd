//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();

            Solution obj = new Solution();

            System.out.println(obj.countPS(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public int countPS(String s) {
        // code here
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            max += isPalindrome(i, i, s);
            max += isPalindrome(i, i + 1, s);
        }

        return max;
    }

    private int isPalindrome(int start, int end, String str) {

        if (start == end) {
            start--;
            end++;
        }

        int count = 0;
        int substrings = 0;

        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            start--;
            end++;

            count += 2;
            if (count >= 2) {
                substrings++;
            }
        }

        return substrings;
        
    }
}