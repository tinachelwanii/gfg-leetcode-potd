//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t > 0) {
            String s = sc.nextLine();
            Solution ob = new Solution();
            if (ob.sentencePalindrome(s))
                System.out.println("true");
            else
                System.out.println("false");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {

    public boolean sentencePalindrome(String s) {
        // code here
    String filtered = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    int left = 0, right = filtered.length() - 1;
    while (left < right) {
        if (filtered.charAt(left) != filtered.charAt(right)) {
            return false;
        }
            left++;
            right--;
        }
        return true;
    }
}
