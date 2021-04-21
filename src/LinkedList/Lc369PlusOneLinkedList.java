package LinkedList;

public class Lc369PlusOneLinkedList {
    class Solution {
        public ListNode plusOne(ListNode head) {
            // Corner case
            if (head == null) return head;

            if (plusOneHelper(head) == 0) {
                return head;
            } else {
                ListNode dummyNode = new ListNode(1);
                dummyNode.next = head;
                return dummyNode;
            }
        }

        private int plusOneHelper(ListNode head) {
            // Base case
            if (head == null) return 1;

            int carry = plusOneHelper(head.next);
            if (carry == 0) return 0;
            int val = head.val + carry;
            head.val = val % 10;
            return val / 10;
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
