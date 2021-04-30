package StringAlgorithm;

public class Lc38CountandSay {
    class Solution {
        public String countAndSay(int n) {
            int i = 1;
            String res = "1";

            while (i < n) {
                StringBuilder sb = new StringBuilder();
                int count = 0;
                char curChar = res.charAt(0);
                for (int j = 0; j <= res.length(); j++) {
                    if (j != res.length() && res.charAt(j) == curChar) {
                        count ++;
                    } else {
                        sb.append(count);
                        sb.append(curChar);
                        if (j != res.length()) {
                            count = 1;
                            curChar = res.charAt(j);
                        }
                    }
                }
                res = String.valueOf(sb);
                i ++;
            }

            return res;
        }
    }
}
