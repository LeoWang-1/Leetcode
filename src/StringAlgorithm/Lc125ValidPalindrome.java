package StringAlgorithm;

public class Lc125ValidPalindrome {
    class Solution {
        public boolean isPalindrome(String s) {
            // Corner case
            if (s == null) return false;
            if (s.length() == 0) return true;

            s = s.toLowerCase();
            int start = 0;
            int end = s.length() - 1;

            while (start < end) {
                if (!Character.isLetterOrDigit(s.charAt(start))) {
                    start ++;
                } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                    end --;
                } else {
                    if (s.charAt(start) != s.charAt(end)) {
                        return false;
                    } else {
                        start ++;
                        end --;
                    }
                }
            }
            return true;
        }
    }
}
