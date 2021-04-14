package LinkedList;

public class Lc234PalindromeLinkedList {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            // Corner case
            if (head == null) return false;

            // Reverse
            ListNode fastNode = head;
            ListNode slowNode = head;

            while (fastNode != null && fastNode.next != null && fastNode.next.next != null) {
                fastNode = fastNode.next.next;
                slowNode = slowNode.next;
            }

            ListNode nextHead = reverseLinkedList(slowNode.next);

            slowNode.next = nextHead;
            slowNode = slowNode.next;

            ListNode firstNode = head;
            while (slowNode != null) {
                if (firstNode.val != slowNode.val) return false;
                slowNode = slowNode.next;
                firstNode = firstNode.next;
            }

            return true;
        }

        private ListNode reverseLinkedList(ListNode head) {
            ListNode curNode = head;
            ListNode preNode = null;
            ListNode nextNode = null;

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
