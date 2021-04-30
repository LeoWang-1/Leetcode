package StringAlgorithm;

public class Lc28ImplementstrStr {
    class Solution {
        public int strStr(String haystack, String needle) {
            // Corner case
            if (needle == null || needle.length() == 0) return 0;

            int start = 0;
            for (int i = 0; i < haystack.length(); i++) {
                if (i + needle.length() > haystack.length()) return -1;
                if (haystack.charAt(i) == needle.charAt(0)) {
                    for (int j = 0; j < needle.length(); j++) {
                        if (haystack.charAt(i + j) != needle.charAt(j)) {
                            break;
                        } else {
                            if (j == needle.length() - 1) return i;
                        }
                    }
                }
            }
            return -1;
        }
    }
}
