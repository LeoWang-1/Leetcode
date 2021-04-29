package BinaryTreeAlgorithm;

public class Lc572SubtreeofAnotherTree {
    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            // Corner case
            if (root == null && subRoot == null) return true;
            if (root == null || subRoot == null) return false;
            if (isSameTree(root, subRoot)) return true;

            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        private boolean isSameTree(TreeNode root, TreeNode subRoot) {
            // Base case
            if (root == null && subRoot == null) return true;
            if (root == null || subRoot == null) return false;
            if (root.val != subRoot.val) return false;

            return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
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
