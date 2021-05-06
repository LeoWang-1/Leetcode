package BinaryTreeAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Lc366FindLeavesofBinaryTree {
    class Solution {
        public List<List<Integer>> findLeaves(TreeNode root) {
            // Corner case
            if (root == null) return new ArrayList<>();

            List<List<Integer>> allLeaves = new ArrayList<>();
            findLeavesHelper(root, allLeaves);
            return allLeaves;
        }

        private int findLeavesHelper(TreeNode root, List<List<Integer>> allLeaves) {
            // Base case
            if (root == null) return -1;

            // Next step
            int leftChildHeight = findLeavesHelper(root.left, allLeaves);
            int rightChildHeight = findLeavesHelper(root.right, allLeaves);
            int curRootHeight = Math.max(leftChildHeight, rightChildHeight) + 1;

            if (allLeaves.size() >= curRootHeight + 1) {
                List<Integer> temp = allLeaves.get(curRootHeight);
                temp.add(root.val);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(root.val);
                allLeaves.add(temp);
            }

            return curRootHeight;
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
