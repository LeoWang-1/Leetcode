package LinkedList;

public class Lc83RemoveDuplicatesfromSortedList {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            // Corner case
            if(head == null || head.next == null) return head;

            ListNode cur = head;
            while(cur != null && cur.next != null) {
                if(cur.val == cur.next.val){
                    cur.next = cur.next.next;
                }else{
                    cur = cur.next;
                }
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
