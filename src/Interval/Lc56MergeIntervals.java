package Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc56MergeIntervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            // Corner case
            if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) {
                return new int[0][0];
            }

            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            List<List<Integer>> tempRes = new ArrayList<>();
            int start = intervals[0][0];
            int end = intervals[0][1];

            for (int[] interval : intervals) {
                if (interval[0] <= end) {
                    end = Math.max(interval[1], end);
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(start);
                    temp.add(end);
                    tempRes.add(temp);
                    start = interval[0];
                    end = interval[1];
                }
            }
            List<Integer> lastInterval = new ArrayList<>();
            lastInterval.add(start);
            lastInterval.add(end);
            tempRes.add(lastInterval);
            int[][] res = new int[tempRes.size()][2];
            for (int i = 0; i < tempRes.size(); i++) {
                res[i][0] = tempRes.get(i).get(0);
                res[i][1] = tempRes.get(i).get(1);
            }

            return res;
        }
    }
}
