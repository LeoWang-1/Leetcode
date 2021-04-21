package LinkedList;

public class Lc2AddTwoNumbers {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // Corner case
            if (l1 == null && l2 == null) return null;
            if (l1 == null && l2 != null) return l2;
            if (l1 != null && l2 == null) return l1;

            ListNode dummyNode = new ListNode(0);
            ListNode curNode = dummyNode;

            int sum = 0;
            while (l1 != null || l2 != null) {
                if(l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }
                ListNode newNode = new ListNode(sum % 10);
                curNode.next = newNode;
                sum = sum / 10;
                curNode = curNode.next;
            }

            if (sum > 0) {
                ListNode newNode = new ListNode(sum);
                curNode.next = newNode;
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
