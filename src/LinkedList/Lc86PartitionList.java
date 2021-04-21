package LinkedList;

public class Lc86PartitionList {
    class Solution {
        public ListNode partition(ListNode head, int x) {
            // Corner case
            if (head == null) return head;

            ListNode dummyNodeSmall = new ListNode(0);
            ListNode dummyNodeLarge = new ListNode(0);
            ListNode curSmall = dummyNodeSmall;
            ListNode curLarge = dummyNodeLarge;

            while (head != null) {
                if (head.val < x) {
                    curSmall.next = head;
                    curSmall = curSmall.next;
                } else {
                    curLarge.next = head;
                    curLarge = curLarge.next;
                }
                head = head.next;
            }
            curLarge.next = null;
            curSmall.next = dummyNodeLarge.next;
            return dummyNodeSmall.next;
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
