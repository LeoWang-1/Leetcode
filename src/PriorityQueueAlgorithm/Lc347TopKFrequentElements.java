package PriorityQueueAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Lc347TopKFrequentElements {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            // Corner case
            if (nums == null || nums.length == 0) return new int[0];

            Map<Integer, Integer> numsCount = new HashMap<>();
            for (int num : nums) {
                if (numsCount.containsKey(num)) {
                    numsCount.put(num, numsCount.get(num) + 1);
                } else {
                    numsCount.put(num, 1);
                }
            }

            PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
            for (Map.Entry<Integer, Integer> entry : numsCount.entrySet()) {
                minHeap.offer(entry);
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
            int[] result = new int[k];
            while (!minHeap.isEmpty()) {
                result[k - 1] = minHeap.poll().getKey();
                k --;
            }
            return result;
        }
    }
}
