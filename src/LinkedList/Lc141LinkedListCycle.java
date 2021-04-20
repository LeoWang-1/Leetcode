package LinkedList;

public class Lc141LinkedListCycle {
    class Solution {
        public boolean hasCycle(ListNode head) {
            // Corner case
            if (head == null || head.next == null) return false;

            ListNode slowNode = head;
            ListNode fastNode = head;

            while (fastNode != null && fastNode.next != null) {
                slowNode = slowNode.next;
                fastNode = fastNode.next.next;
                if (slowNode == fastNode) return true;
            }

            return false;
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
