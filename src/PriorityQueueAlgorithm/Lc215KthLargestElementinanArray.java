package PriorityQueueAlgorithm;

import java.util.PriorityQueue;

public class Lc215KthLargestElementinanArray {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // Corner case
            if (nums == null || nums.length == 0) return 0;

            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);

            for (int num : nums) {
                if (minHeap.size() < k) {
                    minHeap.offer(num);
                } else {
                    if (num > minHeap.peek()) {
                        minHeap.poll();
                        minHeap.offer(num);
                    }
                }
            }
            return minHeap.peek();
        }
    }
}
