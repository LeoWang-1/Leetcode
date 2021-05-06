package BinaryTreeAlgorithm;

public class Lc236LowestCommonAncestorofaBinaryTree {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // Base case
            if (root == null) return null;
            if (root.val == p.val || root.val == q.val) return root;

            TreeNode leftChild = lowestCommonAncestor(root.left, p, q);
            TreeNode rightChild = lowestCommonAncestor(root.right, p, q);

            if (leftChild != null && rightChild != null) return root;
            else if (leftChild == null && rightChild != null) return rightChild;
            else if (leftChild != null && rightChild == null) return leftChild;
            return null;
        }
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
