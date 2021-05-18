package PriorityQueueAlgorithm;

import java.util.PriorityQueue;

public class Lc360SortTransformedArray {
    class Solution {
        public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
            // Corner case
            if (nums == null || nums.length == 0) return new int[0];

            PriorityQueue<Integer> minHeap = new PriorityQueue<>((num1, num2) -> num1 - num2);
            for (int i = 0; i < nums.length; i++) {
                int sum = a * nums[i] * nums[i] + b * nums[i] + c;
                minHeap.offer(sum);
            }

            int[] res = new int[minHeap.size()];
            int index = 0;
            while (!minHeap.isEmpty()) {
                res[index] = minHeap.poll();
                index ++;
            }

            return res;
        }
    }
}
