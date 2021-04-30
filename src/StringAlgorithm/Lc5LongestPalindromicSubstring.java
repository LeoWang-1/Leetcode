package StringAlgorithm;

public class Lc5LongestPalindromicSubstring {
    class Solution {
        String resStr = "";

        public String longestPalindrome(String s) {
            // Corner case
            if (s == null || s.length() == 0) return "";

            for (int i = 0; i < s.length(); i ++) {
                isValidPalindrome(i, i, s);
                isValidPalindrome(i, i + 1, s);
            }
            return resStr;
        }

        private void isValidPalindrome(int left, int right, String s) {
            while (left >= 0 && right <= s.length() - 1) {
                if (s.charAt(left) == s.charAt(right)) {
                    left --;
                    right ++;
                } else {
                    break;
                }
            }
            String tempStr = s.substring(left + 1, right);
            if (tempStr.length() > resStr.length()) resStr = tempStr;
        }
    }
}
