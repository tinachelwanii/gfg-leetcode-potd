//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String [] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-- > 0) {
			int N = sc.nextInt();
			Solution obj = new Solution();
			obj.toBinary(N);
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	void toBinary(int N) {
		//Write your code here
		int pow=0;
		int binNum=0;
		while(N>0){
		    int rem=N%2;
		    binNum=binNum+(rem*(int)Math.pow(10,pow));
		    pow++;
		    N=N/2;
		}
		System.out.print(binNum);
	}
}