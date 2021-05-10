package ArrayAlgorithm;

public class Lc75SortColors {
    class Solution {
        public void sortColors(int[] nums) {
            // Corner case
            if (nums == null || nums.length == 0) return;

            int zero = -1;
            int two = nums.length;
            int i = 0;

            while (i < two) {
                if (nums[i] == 0) {
                    zero ++;
                    swapIndex(nums, i, zero);
                    i ++;
                } else if (nums[i] == 1) {
                    i ++;
                } else {
                    two --;
                    swapIndex(nums, i, two);
                }
            }
        }

        private void swapIndex(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
