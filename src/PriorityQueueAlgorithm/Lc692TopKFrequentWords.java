package PriorityQueueAlgorithm;

import java.util.*;

public class Lc692TopKFrequentWords {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            // Corner case
            if (words == null || words.length == 0) return new ArrayList<>();

            Map<String, Integer> strCount = new HashMap<>();
            for (String str : words) {
                if (strCount.containsKey(str)) {
                    strCount.put(str, strCount.get(str) + 1);
                } else {
                    strCount.put(str, 1);
                }
            }

            PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());


            for (Map.Entry<String, Integer> entry : strCount.entrySet()) {
                minHeap.offer(entry);
                if (minHeap.size() > k) minHeap.poll();
            }
            List<String> result = new ArrayList<>();
            while (k > 0) {
                result.add(0, minHeap.poll().getKey());
                k --;
            }
            return result;
        }
    }
}
