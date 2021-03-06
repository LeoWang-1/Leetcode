package BinarySearchTreeAlgorithm;

public class Lc669TrimaBinarySearchTree {
    class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            // Base case
            if (root == null) return null;

            // Next step
            if (root.val < low) return trimBST(root.right, low, high);
            if (root.val > high) return trimBST(root.left, low, high);

            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);

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
