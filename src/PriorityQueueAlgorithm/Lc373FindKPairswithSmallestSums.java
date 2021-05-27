package PriorityQueueAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Lc373FindKPairswithSmallestSums {
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            // Corner case
            if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0) return new ArrayList<>();

            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] + b[1]) - (a[0] + a[1]));
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    int[] pair = new int[2];
                    pair[0] = nums1[i];
                    pair[1] = nums2[j];
                    maxHeap.offer(pair);
                    if (maxHeap.size() > k) maxHeap.poll();
                }
            }

            List<List<Integer>> res = new ArrayList<>();
            while (!maxHeap.isEmpty()) {
                int[] pair = maxHeap.poll();
                List<Integer> temp = new ArrayList<>();
                temp.add(pair[0]);
                temp.add(pair[1]);
                res.add(0, temp);
            }

            return res;
        }
    }
}
