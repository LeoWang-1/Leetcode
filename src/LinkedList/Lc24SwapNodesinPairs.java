package LinkedList;

public class Lc24SwapNodesinPairs {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            // Base case
            if (head == null || head.next == null) return head;

            ListNode firstNode = head;
            ListNode secondNode = head.next;

            firstNode.next = swapPairs(secondNode.next);
            secondNode.next = firstNode;

            return secondNode;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
