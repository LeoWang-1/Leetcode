package ArrayAlgorithm;

import java.util.Arrays;

public class Lc31NextPermutation {
    class Solution {
        public void nextPermutation(int[] nums) {
            // Corner case
            if (nums == null || nums.length == 0) return;

            // Find the first descrease order number(x) from end to start
            int idx = nums.length - 2;
            while (idx >= 0 && nums[idx] >= nums[idx + 1]) {
                idx --;
            }
            if (idx == - 1) {
                Arrays.sort(nums);
                return;
            }

            // Find the first number which is greater than number x from end to start
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[idx]) {
                j --;
            }

            // Swap the number x and number j
            swapNum(nums, idx, j);

            // Reverse the numbers from idx to end
            reverseNum(nums, idx + 1, nums.length - 1);
        }

        private void swapNum(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private void reverseNum(int[] nums, int i, int j) {
            while (i < j) {
                swapNum(nums, i, j);
                i ++;
                j --;
            }
        }
    }
}
