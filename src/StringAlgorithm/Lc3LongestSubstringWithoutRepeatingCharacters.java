package StringAlgorithm;

import java.util.HashSet;
import java.util.Set;

public class Lc3LongestSubstringWithoutRepeatingCharacters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            // Corner case
            if (s == null || s.length() == 0) return 0;

            Set<Character> checkDuplicated = new HashSet<>();
            int start = 0;
            int end = 0;
            int longestNum = 0;
            while (end < s.length()) {
                if (!checkDuplicated.contains(s.charAt(end))) {
                    checkDuplicated.add(s.charAt(end));
                    end ++;
                    longestNum = Math.max(longestNum, end - start);
                } else {
                    checkDuplicated.remove(s.charAt(start));
                    start ++;
                }
            }
            return longestNum;
        }
    }
}
