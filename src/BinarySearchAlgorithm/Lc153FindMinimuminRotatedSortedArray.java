package BinarySearchAlgorithm;

public class Lc153FindMinimuminRotatedSortedArray {
    class Solution {
        public int findMin(int[] nums) {
            // Corner case
            if (nums == null || nums.length == 0) return -1;

            int left = 0;
            int right = nums.length - 1;
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < nums[right]) {
                    right = mid;
                } else if (nums[mid] > nums[right]) {
                    left = mid;
                } else {
                    right --;
                }
            }
            if (nums[left] < nums[right]) return nums[left];
            else return nums[right];
        }
    }
}
