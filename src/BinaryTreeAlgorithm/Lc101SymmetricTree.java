package BinaryTreeAlgorithm;

public class Lc101SymmetricTree {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            // Corner case
            if (root == null) return true;

            boolean isSymmetricTree = validSymmetricTree(root.left, root.right);
            return isSymmetricTree;
        }

        private boolean validSymmetricTree(TreeNode leftNode, TreeNode rightNode) {
            // Base case
            if (leftNode == null && rightNode == null) return true;
            if (leftNode == null || rightNode == null) return false;
            if (leftNode.val != rightNode.val) return false;

            return validSymmetricTree(leftNode.left, rightNode.right) && validSymmetricTree(leftNode.right, rightNode.left);
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
