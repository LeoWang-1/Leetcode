package BfsAlgorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Lc117PopulatingNextRightPointersinEachNodeII {
    class Solution {
        public Node connect(Node root) {
            // Corner case
            if (root == null) return root;

            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            Node preNode = null;

            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    Node curNode = queue.poll();
                    if (curNode.left != null) queue.offer(curNode.left);
                    if (curNode.right != null) queue.offer(curNode.right);

                    if (preNode != null) preNode.next = curNode;
                    preNode = curNode;

                    size --;
                }

                preNode = null;
            }

            return root;
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
