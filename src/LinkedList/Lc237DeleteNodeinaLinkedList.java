package LinkedList;

public class Lc237DeleteNodeinaLinkedList {
    class Solution {
        public void deleteNode(ListNode node) {
            // Corner case
            if (node == null) return;

            int curNodeVal = node.val;
            int nextNodeVal = node.next.val;
            node.val = nextNodeVal;
            node.next.val = curNodeVal;

            node.next = node.next.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
