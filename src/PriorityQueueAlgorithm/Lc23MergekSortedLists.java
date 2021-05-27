package PriorityQueueAlgorithm;

import java.util.PriorityQueue;

public class Lc23MergekSortedLists {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            // Corner case
            if (lists == null || lists.length == 0) return null;

            ListNode dummyNode = new ListNode();
            ListNode cur = dummyNode;
            PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
            for (ListNode listNode : lists) {
                if (listNode != null) minHeap.offer(listNode);
            }

            while (!minHeap.isEmpty()) {
                ListNode nextNode = minHeap.poll();
                cur.next = nextNode;
                cur = cur.next;
                if (nextNode.next != null) minHeap.offer(nextNode.next);
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
