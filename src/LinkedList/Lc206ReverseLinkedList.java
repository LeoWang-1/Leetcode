package LinkedList;

public class Lc206ReverseLinkedList {
    class Solution {
        public ListNode reverseList(ListNode head) {
            //Corner case
            if (head == null || head.next == null) return head;

            ListNode preNode = null;
            ListNode nextNode = null;
            ListNode curNode = head;

            while (curNode != null) {
                nextNode = curNode.next;
                curNode.next = preNode;
                preNode = curNode;
                curNode = nextNode;
            }

            return preNode;
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
