package BinarySearchTreeAlgorithm;

public class Lc235LowestCommonAncestorofaBinarySearchTree {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // Corner case
            if (root == null) return root;

            return findLowestCommonAncestor(root, p, q);
        }

        private TreeNode findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // Base case
            if (root == null) return null;
            if (root.val > p.val && root.val > q.val) return findLowestCommonAncestor(root.left, p, q);
            else if (root.val < p.val && root.val < q.val) return findLowestCommonAncestor(root.right, p, q);
            else {
                return root;
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
