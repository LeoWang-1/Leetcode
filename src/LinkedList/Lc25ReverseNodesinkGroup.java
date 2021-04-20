package LinkedList;

public class Lc25ReverseNodesinkGroup {
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            // Corner case
            if (head == null || head.next == null || k == 0) return head;

            int count = 0;
            ListNode cur = head;

            while (cur != null && count != k) {
                cur = cur.next;
                count ++;
            }

            if (count == k) {
                cur = reverseKGroup(cur, k);
                while (count-- > 0) {
                    ListNode tempNode = head.next;
                    head.next = cur;
                    cur = head;
                    head = tempNode;
                }

                head = cur;
            }
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
