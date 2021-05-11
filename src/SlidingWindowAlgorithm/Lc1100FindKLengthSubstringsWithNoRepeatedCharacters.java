package SlidingWindowAlgorithm;

public class Lc1100FindKLengthSubstringsWithNoRepeatedCharacters {
    class Solution {
        public int numKLenSubstrNoRepeats(String S, int K) {
            // Corner case
            if (S == null || S.length() == 0 || K > S.length()) return 0;

            int count = 0;
            int start = 0;
            int end = 0;
            int[] countLetter = new int[26];

            while (end < S.length()) {
                countLetter[S.charAt(end) - 'a'] ++;
                while (countLetter[S.charAt(end) - 'a'] > 1) {
                    countLetter[S.charAt(start) - 'a'] --;
                    start ++;
                }
                if (end - start + 1 == K) {
                    countLetter[S.charAt(start) - 'a'] --;
                    start ++;
                    count ++;
                }
                end ++;
            }
            return count;
        }
    }
}
