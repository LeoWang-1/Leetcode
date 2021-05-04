package Interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Lc253MeetingRoomsII {
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            // Corner case
            if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) {
                return 0;
            }

            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            PriorityQueue<int[]> minHeap = new PriorityQueue<>(intervals.length, (a, b) -> a[1] - b[1]);
            minHeap.offer(intervals[0]);
            for (int i = 1; i < intervals.length; i++) {
                int[] curMeet = minHeap.poll();
                if (intervals[i][0] >= curMeet[1]) {
                    curMeet[1] = intervals[i][1];
                } else {
                    minHeap.offer(intervals[i]);
                }
                minHeap.offer(curMeet);
            }
            return minHeap.size();
        }
    }
}
