package BinaryTreeAlgorithm;

public class Lc226InvertBinaryTree {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            // Corner case
            if (root == null) return root;

            TreeNode newRoot = invertTreeHelper(root);
            return newRoot;
        }

        private TreeNode invertTreeHelper(TreeNode root) {
            // Base case
            if (root == null) return root;

            // Next step
            TreeNode newLeftNode = invertTreeHelper(root.left);
            TreeNode newRightNode = invertTreeHelper(root.right);
            root.left = newRightNode;
            root.right = newLeftNode;

            return root;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
