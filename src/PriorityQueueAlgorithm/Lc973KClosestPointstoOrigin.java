package PriorityQueueAlgorithm;

import java.util.PriorityQueue;

public class Lc973KClosestPointstoOrigin {
    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            // Corner case
            if (points == null || points.length == 0 || points[0] == null || points[0].length == 0) return new int[0][0];

            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

            for (int[] point : points) {
                maxHeap.offer(point);
                if (maxHeap.size() > k) maxHeap.poll();
            }

            int[][] res = new int[k][2];
            int index = 0;
            while (!maxHeap.isEmpty()) {
                int[] cur = maxHeap.poll();
                res[index] = cur;
                index ++;
            }
            return res;
        }
    }
}
