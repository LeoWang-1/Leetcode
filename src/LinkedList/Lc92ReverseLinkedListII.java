package LinkedList;

public class Lc92ReverseLinkedListII {
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // Corner case
            if (head == null || head.next == null) return head;

            ListNode dummyNode = new ListNode(0);
            dummyNode.next = head;

            ListNode curNode = head;
            ListNode preNode = dummyNode;

            for (int i = 0; i < left - 1; i++) {
                curNode = curNode.next;
                preNode = preNode.next;
            }

            ListNode subHead = preNode;
            ListNode subTail = curNode;
            ListNode nextNode = null;

            for (int i = 0; i < right - left + 1; i++) {
                nextNode = curNode.next;
                curNode.next = preNode;
                preNode = curNode;
                curNode = nextNode;
            }

            subHead.next = preNode;
            subTail.next = curNode;

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
