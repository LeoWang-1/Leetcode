package BinaryTreeAlgorithm;

public class Lc104MaximumDepthofBinaryTree {
    class Solution {
        public int maxDepth(TreeNode root) {
            // Corner case
            if (root == null) return 0;

            int depth = findMaxDepth(root);
            return depth;
        }

        private int findMaxDepth(TreeNode root) {
            // Base case
            if (root == null) return 0;

            // Next step
            int leftDepth = findMaxDepth(root.left) + 1;
            int rightDepth = findMaxDepth(root.right) + 1;

            return Math.max(leftDepth, rightDepth);
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
