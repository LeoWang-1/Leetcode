package StringAlgorithm;

public class Lc9PalindromeNumber {
    class Solution {
        public boolean isPalindrome(int x) {
            // Corner case
            if (x < 0 || x % 10 == 0 && x != 0) return false;

            int reverseNum = 0;
            while (x > reverseNum) {
                reverseNum = reverseNum * 10 + x % 10;
                x /= 10;
            }
            return x == reverseNum || x == reverseNum / 10;
        }
    }
}
