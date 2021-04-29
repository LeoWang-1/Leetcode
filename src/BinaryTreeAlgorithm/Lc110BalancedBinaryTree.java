package BinaryTreeAlgorithm;

public class Lc110BalancedBinaryTree {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            // Corner case
            if (root == null) return true;

            boolean isBalancedTree = validBalancedTree(root);
            return isBalancedTree;
        }

        private boolean validBalancedTree(TreeNode root) {
            // Base case
            if (root == null) return true;

            // Next step
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            boolean leftSubtree = validBalancedTree(root.left);
            boolean rightSubtree = validBalancedTree(root.right);

            if (Math.abs(leftHeight - rightHeight) > 1) return false;
            return leftSubtree && rightSubtree;
        }

        private int getHeight(TreeNode root) {
            // Base case
            if (root == null) return 0;

            // Next step
            int leftHeight = getHeight(root.left) + 1;
            int rightHeight = getHeight(root.right) + 1;

            return Math.max(leftHeight, rightHeight);
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
