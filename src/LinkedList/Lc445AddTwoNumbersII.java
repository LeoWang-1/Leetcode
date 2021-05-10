package LinkedList;

public class Lc445AddTwoNumbersII {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // Corner case
            if (l1 == null && l2 == null) return null;
            if (l1 == null) return l2;
            if (l2 == null) return l1;

            ListNode dummyNode = new ListNode(0);
            ListNode curNode = dummyNode;
            ListNode l1ReverseNode = reverseLinkedList(l1);
            ListNode l2ReverseNode = reverseLinkedList(l2);
            int carry = 0;

            while (l1ReverseNode != null || l2ReverseNode != null) {
                int totalSum = 0;
                if (l1ReverseNode != null) {
                    totalSum += l1ReverseNode.val;
                    l1ReverseNode = l1ReverseNode.next;
                }
                if (l2ReverseNode != null) {
                    totalSum += l2ReverseNode.val;
                    l2ReverseNode = l2ReverseNode.next;
                }

                totalSum += carry;
                ListNode nextNode = new ListNode(totalSum % 10);
                curNode.next = nextNode;
                curNode = nextNode;
                carry = totalSum / 10;
            }

            if (carry == 1) {
                ListNode nextNode = new ListNode(1);
                curNode.next = nextNode;
            }

            return reverseLinkedList(dummyNode.next);

        }

        private ListNode reverseLinkedList(ListNode root) {
            ListNode preNode = null;
            ListNode nextNode = null;
            ListNode curNode = root;

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
