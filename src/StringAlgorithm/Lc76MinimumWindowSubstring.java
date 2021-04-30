package StringAlgorithm;

public class Lc76MinimumWindowSubstring {
    class Solution {
        public String minWindow(String s, String t) {
            // Corner case
            if (s == null || s.length() == 0) return "";
            if (s.length() < t.length()) return "";
            int[] countT = new int[256];
            for (int i = 0; i < t.length(); i++) {
                countT[t.charAt(i)] ++;
            }

            int totalStr = t.length();
            int start = 0;
            int end = 0;
            int fromPos = 0;
            int min = Integer.MAX_VALUE;
            while (end < s.length()) {
                if (countT[s.charAt(end)] > 0) {

                    totalStr --;
                }
                countT[s.charAt(end)]--;
                while (totalStr == 0) {
                    if (end - start + 1 < min) {
                        min = end - start + 1;
                        fromPos = start;
                    }
                    countT[s.charAt(start)] ++;
                    if (countT[s.charAt(start)] > 0) {
                        totalStr ++;
                    }
                    start++;
                }
                end ++;
            }
            return min == Integer.MAX_VALUE ? "" : s.substring(fromPos, fromPos + min);
        }
    }
}
