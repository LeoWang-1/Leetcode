package BinaryTreeAlgorithm;

public class Lc1644LowestCommonAncestorofaBinaryTreeII {
    class Solution {
        // Fields
        int count = 0;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // Corner case
            if (root == null) return root;

            // Check whether tree has two nodes
            isTwoNodesExist(root, p, q);
            if (count != 2) return null;
            return findLCA(root, p, q);
        }

        private void isTwoNodesExist(TreeNode root, TreeNode p, TreeNode q) {
            // Base case
            if (root == null) return;

            // Next steps
            if (root == p || root == q) count ++;
            isTwoNodesExist(root.left, p, q);
            isTwoNodesExist(root.right, p, q);
        }

        private TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
            // Base case
            if (root == null) return null;
            if (root == p || root == q) return root;

            TreeNode leftChild = findLCA(root.left, p, q);
            TreeNode rightChild = findLCA(root.right, p, q);

            if (leftChild != null && rightChild != null) return root;
            return leftChild == null ? rightChild : leftChild;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
