package BfsAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc107BinaryTreeLevelOrderTraversalII {
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            // Corner case
            if (root == null) return new ArrayList<>();

            List<List<Integer>> nodeWithLevelOrder = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> nodeSameLevel = new ArrayList<>();
                while (size > 0) {
                    TreeNode curNode = queue.poll();
                    if (curNode.left != null) queue.offer(curNode.left);
                    if (curNode.right != null) queue.offer(curNode.right);
                    nodeSameLevel.add(curNode.val);
                    size --;
                }

                nodeWithLevelOrder.add(0, nodeSameLevel);
            }

            return nodeWithLevelOrder;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
