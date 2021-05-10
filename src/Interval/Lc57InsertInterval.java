package Interval;

import java.util.ArrayList;
import java.util.List;

public class Lc57InsertInterval {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            // Corner case
            if ((intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) && (newInterval == null || newInterval.length == 0)) return new int[0][0];

            List<int[]> intervalList = new ArrayList<>();
            int i = 0;

            while (i < intervals.length && intervals[i][1] < newInterval[0]) {
                intervalList.add(new int[]{intervals[i][0], intervals[i][1]});
                i ++;
            }

            while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                i ++;
            }
            intervalList.add(new int[]{newInterval[0], newInterval[1]});

            while (i < intervals.length) {
                intervalList.add(new int[]{intervals[i][0], intervals[i][1]});
                i ++;
            }

            int[][] res = new int[intervalList.size()][2];
            for (i = 0; i < intervalList.size(); i++) {
                res[i][0] = intervalList.get(i)[0];
                res[i][1] = intervalList.get(i)[1];
            }

            return res;
        }
    }
}
