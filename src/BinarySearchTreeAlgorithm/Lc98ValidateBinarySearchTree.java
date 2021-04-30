package BinarySearchTreeAlgorithm;

public class Lc98ValidateBinarySearchTree {
    class Solution {
        public boolean isValidBST(TreeNode root) {
            // Corner case
            if (root == null) return true;

            return isValidHelper(root, null, null);
        }

        private boolean isValidHelper(TreeNode root, Integer minVal, Integer maxVal) {
            // Base case
            if (root == null) return true;
            if (minVal != null && root.val <= minVal || maxVal != null && root.val >= maxVal) return false;

            return isValidHelper(root.left, minVal, root.val) && isValidHelper(root.right, root.val, maxVal);
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
