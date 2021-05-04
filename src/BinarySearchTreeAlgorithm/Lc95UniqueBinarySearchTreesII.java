package BinarySearchTreeAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Lc95UniqueBinarySearchTreesII {
    class Solution {
        public List<TreeNode> generateTrees(int n) {
            // Corner case
            if (n == 0) return new ArrayList<>();

            List<TreeNode> allPossibleTrees = generateAllTrees(1, n);
            return allPossibleTrees;
        }

        private List<TreeNode> generateAllTrees(int start, int end) {
            List<TreeNode> list = new ArrayList<>();
            // Base case
            if (start > end) {
                list.add(null);
            }

            for (int i = start; i <= end; i++) {
                List<TreeNode> leftList = generateAllTrees(start, i - 1);
                List<TreeNode> rightList = generateAllTrees(i + 1, end);
                for (TreeNode left : leftList) {
                    for (TreeNode right : rightList) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        list.add(root);
                    }
                }
            }
            return list;
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
