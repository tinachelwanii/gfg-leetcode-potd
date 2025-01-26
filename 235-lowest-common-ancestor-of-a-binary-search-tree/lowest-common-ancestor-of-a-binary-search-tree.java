/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
        public static boolean getPath(TreeNode root,TreeNode target,ArrayList<TreeNode> path){
        if(root==null){
            return false;
        }
        path.add(root);
        
        if(root==target){
            return true;
        }
        boolean foundleft=getPath(root.left,target,path);
        boolean foundright=getPath(root.right,target,path);
        
        if(foundleft || foundright){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    ArrayList<TreeNode> path1 = new ArrayList<>();
    ArrayList<TreeNode> path2 = new ArrayList<>();
    
    boolean foundP=getPath(root,p,path1);
    boolean foundQ=getPath(root,q,path2);
    
    if (!foundP || !foundQ) {
        return null;
    }

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
}
    