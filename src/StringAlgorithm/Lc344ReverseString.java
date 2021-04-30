package StringAlgorithm;

public class Lc344ReverseString {
    class Solution {
        public void reverseString(char[] s) {
            // Corner case
            if (s == null || s.length == 0) return;

            int left = 0;
            int right = s.length - 1;

            while (left < right) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left ++;
                right --;
            }
        }
    }
}
