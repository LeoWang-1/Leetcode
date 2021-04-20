package LinkedList;

public class Lc19RemoveNthNodeFromEndofList {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // Corner case
            if (head == null) return head;

            ListNode dummyNode = new ListNode(0);
            dummyNode.next = head;
            ListNode fastNode = dummyNode;
            ListNode slowNode = dummyNode;

            while (n-- > 0) {
                fastNode = fastNode.next;
            }

            while (fastNode.next != null) {
                slowNode = slowNode.next;
                fastNode = fastNode.next;
            }

            slowNode.next = slowNode.next.next;

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
