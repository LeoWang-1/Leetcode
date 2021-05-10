package ArrayAlgorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lc349IntersectionofTwoArrays {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            // Corner case
            if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];

            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();

            for (int num1 : nums1) set1.add(num1);
            for (int num2 : nums2) set2.add(num2);

            List<Integer> resList = new ArrayList<>();
            for (Integer num : set1) {
                if (set2.contains(num)) resList.add(num);
            }

            int[] res = new int[resList.size()];
            for (int i = 0; i < resList.size(); i++) {
                res[i] = resList.get(i);
            }

            return res;
        }
    }
}
