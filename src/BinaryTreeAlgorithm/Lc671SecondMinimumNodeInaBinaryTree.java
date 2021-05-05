package BinaryTreeAlgorithm;

public class Lc671SecondMinimumNodeInaBinaryTree {
    class Solution {
        public int findSecondMinimumValue(TreeNode root) {
            // Corner case
            if (root == null) return -1;

            return findSecondMinimumValueHelper(root);
        }

        private int findSecondMinimumValueHelper(TreeNode root) {
            if (root.left == null && root.right == null) return -1;

            int leftChild = -1;
            if (root.left.val == root.val) {
                leftChild = findSecondMinimumValueHelper(root.left);
            } else {
                leftChild = root.left.val;
            }

            int rightChild = -1;
            if (root.right.val == root.val) {
                rightChild = findSecondMinimumValueHelper(root.right);
            } else {
                rightChild = root.right.val;
            }

            if (leftChild == -1 && rightChild == -1) return -1;
            if (leftChild == -1 && rightChild != -1) return rightChild;
            if (leftChild != -1 && rightChild == -1) return leftChild;
            return Math.min(leftChild, rightChild);
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
