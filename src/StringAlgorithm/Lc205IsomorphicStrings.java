package StringAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class Lc205IsomorphicStrings {
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            // Corner case
            if (s == null || t == null) return true;
            if (s.length() != t.length()) return false;

            Map<Character, Character> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char originLetter = s.charAt(i);
                char copyLetter = t.charAt(i);
                if (map.containsKey(originLetter)) {
                    if (map.get(originLetter) != copyLetter) {
                        return false;
                    }
                } else {
                    if (map.containsValue(copyLetter)) {
                        return false;
                    }
                    map.put(originLetter, copyLetter);
                }
            }
            return true;
        }
    }
}
