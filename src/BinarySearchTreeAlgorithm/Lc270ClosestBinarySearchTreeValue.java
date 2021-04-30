package BinarySearchTreeAlgorithm;

public class Lc270ClosestBinarySearchTreeValue {
    class Solution {
        public int closestValue(TreeNode root, double target) {
            // Corner case
            if (root == null) return 0;

            TreeNode curNode = root;
            int nodeVal = root.val;

            while (curNode != null) {
                if (Math.abs(curNode.val - target) <= Math.abs(nodeVal - target)) {
                    nodeVal = curNode.val;
                }
                if (curNode.val <= target) {
                    curNode = curNode.right;
                } else {
                    curNode = curNode.left;
                }
            }

            return nodeVal;
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
