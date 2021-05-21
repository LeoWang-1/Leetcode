package BinaryTreeAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Lc199BinaryTreeRightSideView {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            // Corner case
            if (root == null) return new ArrayList<>();

            List<Integer> rightSideView = new ArrayList<>();
            findRightSideView(root, rightSideView, 0);

            return rightSideView;
        }

        private void findRightSideView(TreeNode root, List<Integer> rightSideView, int level) {
            // Base case
            if (root == null) return;
            if (level == rightSideView.size()) rightSideView.add(root.val);

            if (root.right != null) findRightSideView(root.right, rightSideView, level + 1);
            if (root.left != null) findRightSideView(root.left, rightSideView, level + 1);
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
