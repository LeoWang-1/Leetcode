package LinkedList;

public class Lc160IntersectionofTwoLinkedLists {
    class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // Corner case
            if (headA == null || headB == null) return null;

            ListNode curNodeA = headA;
            ListNode curNodeB = headB;

            while (curNodeA != curNodeB) {
                if (curNodeA != null) {
                    curNodeA = curNodeA.next;
                } else {
                    curNodeA = headB;
                }
                if (curNodeB != null) {
                    curNodeB = curNodeB.next;
                } else {
                    curNodeB = headA;
                }
            }

            return curNodeA;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
      }
  }
}
