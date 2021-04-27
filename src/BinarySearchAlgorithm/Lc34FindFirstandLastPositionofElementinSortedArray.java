package BinarySearchAlgorithm;

public class Lc34FindFirstandLastPositionofElementinSortedArray {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[2];
            result[0] = -1;
            result[1] = -1;
            // Corner case
            if (nums == null || nums.length == 0) return result;

            int left = 0;
            int right = nums.length - 1;
            if (nums[left] > target || nums[right] < target) return result;

            // Find first position
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target) right = mid - 1;
                else left = mid + 1;
            }
            if (nums[left] != target) return result;
            result[0] = left;

            // Find last position
            while (left < nums.length && nums[left] == target) {
                left ++;
            }
            result[1] = left - 1;

            return result;
        }
    }
}
