//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main {
    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            GfG g = new GfG();
            System.out.println(g.findDist(root, a, b));
        }
    }
}

// } Driver Code Ends


// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
        public static boolean getPath(Node root,int n,ArrayList<Node> path){
        if(root==null){
            return false;
        }
        path.add(root);
        
        if(root.data==n){
            return true;
        }
        boolean foundleft=getPath(root.left,n,path);
        boolean foundright=getPath(root.right,n,path);
        
        if(foundleft || foundright){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public static  Node lca(Node root,int a, int b) {
    ArrayList<Node> path1 = new ArrayList<>();
    ArrayList<Node> path2 = new ArrayList<>();
    
    getPath(root,a,path1);
    getPath(root,b,path2);
    
    //last common ancestor
    int i=0;
    while(i<path1.size()&&i<path2.size()){
        if(path1.get(i)!=path2.get(i)){
            break;
        }
        i++;
    }
    //last equal node=i-1th
    return path1.get(i-1);
    } 

        public static int lcaDist(Node root,int a){
        if(root==null){
            return -1;
        }
        if(root.data==a){
            return 0;
        }
        int leftdist = lcaDist(root.left,a);
        int rightdist=lcaDist(root.right,a);
        
        if(leftdist==-1&&rightdist==-1){
            return -1;
        }else if(leftdist==-1){
            return rightdist+1;
        }else{
            return leftdist+1;
        }
    }

    int findDist(Node root, int a, int b) {
        // Your code here
        Node lca =lca(root,a,b);
        int dist1=lcaDist(lca,a);
        int dist2=lcaDist(lca,b);
        return dist2+dist1;

    }
}