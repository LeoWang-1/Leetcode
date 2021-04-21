package LinkedList;

public class Lc143ReorderList {
    class Solution {
        public void reorderList(ListNode head) {
            // Corner case
            if (head == null || head.next == null) return;

            ListNode middleNode = getMiddleNode(head);
            ListNode leftNode = head;
            ListNode rightNode = reverseLinkedList(middleNode.next);
            middleNode.next = null;

            head = mergeList(leftNode, rightNode);
        }

        private ListNode getMiddleNode(ListNode head) {
            ListNode slowNode = head;
            ListNode fastNode = head;

            while (fastNode != null && fastNode.next != null && fastNode.next.next != null) {
                slowNode = slowNode.next;
                fastNode = fastNode.next.next;
            }
            return slowNode;
        }

        private ListNode reverseLinkedList(ListNode head) {
            ListNode preNode = null;
            ListNode nextNode = null;
            ListNode curNode = head;

            while (curNode != null) {
                nextNode = curNode.next;
                curNode.next = preNode;
                preNode = curNode;
                curNode= nextNode;
            }

            return preNode;
        }

        private ListNode mergeList(ListNode leftNode, ListNode rightNode) {
            ListNode dummyNode = new ListNode(0);
            ListNode curNode = dummyNode;

            while (leftNode != null && rightNode != null) {
                curNode.next = leftNode;
                leftNode = leftNode.next;
                curNode = curNode.next;

                curNode.next = rightNode;
                rightNode = rightNode.next;
                curNode = curNode.next;
            }

            if (leftNode != null) curNode.next = leftNode;
            if (rightNode != null) curNode.next = rightNode;

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
