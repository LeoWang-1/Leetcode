package BinaryTreeAlgorithm;

public class Lc156BinaryTreeUpsideDown {
    class Solution {
        public TreeNode upsideDownBinaryTree(TreeNode root) {
            // Corner case
            if (root == null) return root;

            return upsideDownBinaryTreeHelper(root);
        }

        private TreeNode upsideDownBinaryTreeHelper(TreeNode root) {
            // Base case
            if (root == null || root.left == null && root.right == null) return root;

            TreeNode leftResult = upsideDownBinaryTreeHelper(root.left);
            TreeNode rightResult = upsideDownBinaryTreeHelper(root.right);
            TreeNode leftChild = root.left;

            root.left = null;
            root.right = null;
            leftChild.left = rightResult;
            leftChild.right = root;

            return leftResult;
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
