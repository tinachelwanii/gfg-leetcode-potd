//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Node root = null;

            // Read inorder array
            String[] inorderStr = (br.readLine()).trim().split(" ");
            int inorder[] = new int[inorderStr.length];
            for (int i = 0; i < inorderStr.length; i++) {
                inorder[i] = Integer.parseInt(inorderStr[i]);
            }

            // Read preorder array
            String[] preorderStr = (br.readLine()).trim().split(" ");
            int preorder[] = new int[preorderStr.length];
            for (int i = 0; i < preorderStr.length; i++) {
                preorder[i] = Integer.parseInt(preorderStr[i]);
            }

            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder);
            postOrder(root);
            System.out.println();
        }
    }

    // Function to print postorder traversal of the tree
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    static int pos;
    public static Node buildTree(int inorder[], int preorder[]) {
        // code here
        pos = 0;
        return solve(inorder, preorder, 0, inorder.length-1);
    }
    static Node solve(int inorder[], int preorder[], int str, int end){
        if(str>inorder.length || str> end){
            return null;
        }
        Node root = new Node(preorder[pos]);
        int div = 0;
        for(int i=str;i<=end;i++){
            if(preorder[pos] == inorder[i]){
                div = i;
                break;
            }
        }
        pos++;
        root.left = solve(inorder, preorder, str, div-1);
        root.right = solve(inorder, preorder, div+1, end);
        return root;
    }
}