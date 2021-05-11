package BinaryTreeAlgorithm;

public class Lc1448CountGoodNodesinBinaryTree {
    class Solution {
        int count = 0;
        public int goodNodes(TreeNode root) {
            // Corner case
            if (root == null) return 0;

            findAllGoodNodes(root, Integer.MIN_VALUE);
            return count;
        }

        private void findAllGoodNodes(TreeNode root, Integer maxValue) {
            // Base case
            if (root == null) return;

            // Next step
            if (root.val >= maxValue) {
                count ++;
                maxValue = root.val;
            }
            findAllGoodNodes(root.left, maxValue);
            findAllGoodNodes(root.right, maxValue);
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
