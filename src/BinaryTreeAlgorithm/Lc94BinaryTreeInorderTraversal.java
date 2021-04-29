package BinaryTreeAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Lc94BinaryTreeInorderTraversal {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            // Corner case
            if (root == null) return new ArrayList<>();

            List<Integer> allNodes = new ArrayList<>();
            findAllNodes(root, allNodes);
            return allNodes;
        }

        private void findAllNodes(TreeNode root, List<Integer> allNodes) {
            // Base case
            if (root == null) return;

            // Next steps
            if (root.left != null) findAllNodes(root.left, allNodes);
            allNodes.add(root.val);
            if (root.right != null) findAllNodes(root.right, allNodes);
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
