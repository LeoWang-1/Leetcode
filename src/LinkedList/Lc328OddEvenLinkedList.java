package LinkedList;

public class Lc328OddEvenLinkedList {
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            // Corner case
            if (head == null || head.next == null) return head;

            ListNode oddNode = head;
            ListNode evenNode = head.next;
            ListNode evenHead = evenNode;

            while (evenNode != null && evenNode.next != null) {
                oddNode.next = evenNode.next;
                oddNode = oddNode.next;
                evenNode.next = oddNode.next;
                evenNode = evenNode.next;
            }
            oddNode.next = evenHead;
            return head;
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
