package BinarySearchAlgorithm;

public class Lc744FindSmallestLetterGreaterThanTarget {
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            // Corner case
            if (letters == null || letters.length == 0) return 'a';

            int left = 0;
            int right = letters.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (letters[mid] - 'a' > target - 'a') {
                    right = mid - 1;
                } else{
                    left = mid + 1;
                }
            }
            if (left >= letters.length) return letters[0];
            return letters[left];
        }
    }
}
