package BinaryTreeAlgorithm;

public class Lc1644LowestCommonAncestorofaBinaryTreeII {
    class Solution {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // Corner case
            if (root == null) return null;

            Pair pair = lowestCommonAncestorHelper(root, p, q);
            if (pair.numOfNode == 2) return pair.node;
            else return null;
        }

        private Pair lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
            // Base case
            if (root == null) return new Pair(null, 0);

            Pair leftChildPair = lowestCommonAncestorHelper(root.left, p, q);
            Pair rightChildPair = lowestCommonAncestorHelper(root.right, p, q);

            if (root.val == p.val || root.val == q.val) return new Pair(root, 1 + leftChildPair.numOfNode + rightChildPair.numOfNode);
            if (leftChildPair.numOfNode != 0 && rightChildPair.numOfNode != 0) return new Pair(root, 2);
            return leftChildPair.numOfNode == 0 ? rightChildPair : leftChildPair;
        }

        private class Pair{
            TreeNode node = null;
            int numOfNode = 0;
            Pair (TreeNode node, int numOfNode) {
                this.node = node;
                this.numOfNode = numOfNode;
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
