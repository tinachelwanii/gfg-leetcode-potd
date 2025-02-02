//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution {

     public boolean isPossible(int k, int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int size1 = arr1.length;
        int size2 = arr2.length;
        int start =0, end = size2-1;
        
        while(start<end){
            int temp = arr2[start];
            arr2[start] = arr2[end];
            arr2[end]= temp;
            start++;
            end--;
            
        }
        
            for(int i=0; i<size1; i++){
                if(arr1[i]+arr2[i] < k){
                    return false;
                }
            }
            
        return true;
    }

}




//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            String[] arr1Str = sc.nextLine().split(" ");
            String[] arr2Str = sc.nextLine().split(" ");

            int[] arr1 = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int[] arr2 = Arrays.stream(arr2Str).mapToInt(Integer::parseInt).toArray();

            Solution solution = new Solution();
            boolean result = solution.isPossible(k, arr1, arr2);

            if (result) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        
System.out.println("~");
}
        sc.close();
    }
}
// } Driver Code Ends