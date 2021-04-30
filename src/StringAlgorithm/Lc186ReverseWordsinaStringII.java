package StringAlgorithm;

public class Lc186ReverseWordsinaStringII {
    class Solution {
        public void reverseWords(char[] s) {
            // Corner case
            if (s == null || s.length == 0) return;

            // Reverse all letters
            reverse(s, 0, s.length - 1);

            // Reverse each word
            int slow = 0;
            int fast = 0;

            while (fast < s.length) {
                if (s[fast] == ' ') {
                    reverse(s, slow, fast - 1);
                    slow = fast + 1;
                } else if (fast == s.length - 1) {
                    reverse(s, slow, fast);
                    slow = fast;
                }
                fast ++;
            }
        }

        private void reverse(char[] s, int start, int end) {
            while (start < end) {
                char temp = s[start];
                s[start] = s[end];
                s[end] = temp;
                start ++;
                end --;
            }
        }

        private void reverseEachWord(char[] s) {
            int slow = 0;
            int fast = 0;

            while (fast < s.length) {

            }
        }
    }
}
