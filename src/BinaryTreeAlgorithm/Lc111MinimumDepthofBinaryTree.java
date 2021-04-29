package BinaryTreeAlgorithm;

public class Lc111MinimumDepthofBinaryTree {
    class Solution {
        public int minDepth(TreeNode root) {
            // Corner case
            if (root == null) return 0;

            int minDepth = findMinDepth(root);
            return minDepth;
        }

        private int findMinDepth(TreeNode root) {
            // Base case
            if (root == null) return 0;

            // Next steps
            int leftDepth = findMinDepth(root.left);
            int rightDepth = findMinDepth(root.right);
            if (leftDepth == 0) return rightDepth + 1;
            if (rightDepth == 0) return leftDepth + 1;

            return Math.min(leftDepth, rightDepth) + 1;
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
