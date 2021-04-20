package LinkedList;

public class Lc148SortList {
    class Solution {
        public ListNode sortList(ListNode head) {
            // Corner case
            if (head == null || head.next == null) return head;

            ListNode middleNode = getMiddleNode(head);
            ListNode nextNode = middleNode.next;
            middleNode.next = null;
            return mergeListNode(sortList(head), sortList(nextNode));
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

        private ListNode mergeListNode(ListNode nodeA, ListNode nodeB) {
            ListNode dummyNode = new ListNode(0);
            ListNode curNode = dummyNode;

            while(nodeA != null && nodeB != null) {
                if (nodeA.val <= nodeB.val) {
                    curNode.next = nodeA;
                    nodeA = nodeA.next;
                } else {
                    curNode.next = nodeB;
                    nodeB = nodeB.next;
                }
                curNode = curNode.next;
            }
            if (nodeA != null) curNode.next = nodeA;
            if (nodeB != null) curNode.next = nodeB;

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
