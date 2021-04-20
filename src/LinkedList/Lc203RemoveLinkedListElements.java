package LinkedList;

public class Lc203RemoveLinkedListElements {
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            // Corner case
            if (head == null) return head;

            ListNode dummyNode = new ListNode(0);
            dummyNode.next = head;
            ListNode curNode = dummyNode;


            while (curNode.next != null) {
                if (curNode.next.val == val) {
                    curNode.next = curNode.next.next;
                } else {
                    curNode = curNode.next;
                }
            }

            return dummyNode.next;
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
