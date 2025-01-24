//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.binaryToDecimal(str);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int binaryToDecimal(String b) {
        // Code here
        int pow=0;
        int decNum=0;
        for(int i=b.length()-1;i>=0;i--){
            char bit = b.charAt(i);
            if (bit == '1') {
                decNum += (int) Math.pow(2, pow);
            }
            pow++;
        }
        return decNum;
    }
}

        