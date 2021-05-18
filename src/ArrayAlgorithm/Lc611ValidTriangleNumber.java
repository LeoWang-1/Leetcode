package ArrayAlgorithm;

import java.util.Arrays;

public class Lc611ValidTriangleNumber {
    class Solution {
        public int triangleNumber(int[] nums) {
            // Corner case
            if (nums == null || nums.length == 0) return 0;

            Arrays.sort(nums);
            int count = 0;
            for (int third = nums.length - 1; third > 1; third --) {
                for (int first = 0, second = third - 1; first < second;) {
                    if (nums[first] + nums[second] > nums[third]) {
                        count += second - first;
                        second --;
                    } else {
                        first ++;
                    }
                }
            }
            return count;
        }
    }
}
