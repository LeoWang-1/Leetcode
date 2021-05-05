package ArrayAlgorithm;

public class Lc88MergeSortedArray {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // Corner case
            if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return;

            int point1 = m - 1;
            int point2 = n - 1;
            while (point1 >= 0 && point2 >= 0) {
                if (nums1[point1] >= nums2[point2]) {
                    nums1[point1 + point2 + 1] = nums1[point1];
                    point1 --;
                } else {
                    nums1[point1 + point2 + 1] = nums2[point2];
                    point2 --;
                }
            }
            while (point2 >= 0) {
                nums1[point2] = nums2[point2];
                point2 --;
            }
        }
    }
}
