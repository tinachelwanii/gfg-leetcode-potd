//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int N = sc.nextInt();
                    int Arr[] = new int[N];
                    for(int i = 0;i<N;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.gcd(N,Arr));
                
System.out.println("~");
}
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    private int gcdtwonumbers(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public int gcd(int N , int arr[]) 
    { 
       //code here.
       int result = arr[0];
       for(int i=0;i<N;i++){
           result = gcdtwonumbers(result,arr[i]);
           if(result==1){
               return 1;
           }
       }
       return result;
    } 
}