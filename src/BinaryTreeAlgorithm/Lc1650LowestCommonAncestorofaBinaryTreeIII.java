package BinaryTreeAlgorithm;

import java.util.HashSet;
import java.util.Set;

public class Lc1650LowestCommonAncestorofaBinaryTreeIII {
    class Solution {
        public Node lowestCommonAncestor(Node p, Node q) {
            // Corner case
            if (p == null || q == null) return null;

            Set<Node> pParentNodes = new HashSet<>();
            findParentNodes(p, pParentNodes);
            Node LCANode = findLCAHelper(q, pParentNodes);
            return LCANode;
        }

        private void findParentNodes(Node target, Set<Node> targetParentNodes) {
            // Base case
            if (target.parent == null) {
                targetParentNodes.add(target);
                return;
            }

            // Next steps
            targetParentNodes.add(target);
            findParentNodes(target.parent, targetParentNodes);
        }

        private Node findLCAHelper(Node target, Set<Node> sourceParentNodes) {
            // Base case
            if (target == null) return null;

            if (sourceParentNodes.contains(target)) return target;
            return findLCAHelper(target.parent, sourceParentNodes);
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
}
