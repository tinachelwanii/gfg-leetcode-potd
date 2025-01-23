class Solution {
    static class Info {
        int diam; // Diameter of the subtree
        int ht;   // Height of the subtree

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getTreeInfo(root).diam - 1; // Subtract 1 to convert nodes to edges
    }

    // Recursive helper function to calculate diameter and height
    private static Info getTreeInfo(TreeNode node) {
        if (node == null) {
            return new Info(0, 0); // Base case: diameter and height are 0
        }

        Info leftInfo = getTreeInfo(node.left);   // Information for the left subtree
        Info rightInfo = getTreeInfo(node.right); // Information for the right subtree

        // Calculate the diameter
        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        // Calculate the height
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Diameter of Binary Tree: " + diameterOfBinaryTree(root));
    }
}

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}
