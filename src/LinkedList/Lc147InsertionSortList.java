package LinkedList;

public class Lc147InsertionSortList {
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            // Corner case
            if (head == null || head.next == null) return head;

            ListNode dummyNode = new ListNode(0);
            dummyNode.next = head;
            ListNode curNode = head;
            ListNode changeNode = null;
            ListNode preNode = null;

            while (curNode != null && curNode.next != null) {
                if (curNode.val <= curNode.next.val) {
                    curNode = curNode.next;
                } else {
                    changeNode = curNode.next;
                    curNode.next = curNode.next.next;
                    preNode = dummyNode;
                    while (preNode.next != null && preNode.next.val <= changeNode.val) {
                        preNode = preNode.next;
                    }
                    changeNode.next = preNode.next;
                    preNode.next = changeNode;
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
