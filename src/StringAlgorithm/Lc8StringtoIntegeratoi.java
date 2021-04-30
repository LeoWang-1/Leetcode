package StringAlgorithm;

public class Lc8StringtoIntegeratoi {
    class Solution {
        public int myAtoi(String s) {
            s = s.trim();
            // Corner case
            if (s == null || s.length() == 0) return 0;

            int start = 0;
            char firstChar = s.charAt(start);
            int sign = 1;
            long res = 0;
            if (firstChar == '+') {
                sign = 1;
                start ++;
            }
            if (firstChar == '-') {
                sign = -1;
                start ++;
            }

            for (int i = start; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    return (int) res * sign;
                }
                res = res * 10 + (s.charAt(i) - '0');
                if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if (sign == -1 && res > Integer.MAX_VALUE) return Integer.MIN_VALUE;
            }
            return (int) res * sign;
        }
    }
}
