package ArrayAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc350IntersectionofTwoArraysII {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            // Corner case
            if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];

            Map<Integer, Integer> map = new HashMap<>();
            List<Integer> temp = new ArrayList<>();
            for (int num : nums1) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }

            for (int num : nums2) {
                if (map.containsKey(num) && map.get(num) != 0) {
                    temp.add(num);
                    map.put(num, map.get(num) - 1);
                }
            }

            int[] res = new int[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                res[i] = temp.get(i);
            }

            return res;
        }
    }
}
