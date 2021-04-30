package StringAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc49GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            // Corner case
            if (strs == null || strs.length == 0) return new ArrayList<>();

            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                int[] count = new int[256];
                StringBuilder singleWord = new StringBuilder();
                char[] strArray = str.toCharArray();
                for (int i = 0; i < strArray.length; i++) {
                    count[strArray[i] - 'a'] ++;
                }
                for (int i = 0; i < count.length; i++) {
                    if (count[i] != 0) {
                        singleWord.append(count[i]);
                        singleWord.append((char) i + 'a');
                    }
                }
                if (map.containsKey(singleWord.toString())) {
                    map.get(singleWord.toString()).add(str);
                } else {
                    List<String> temp = new ArrayList<>();
                    temp.add(str);
                    map.put(singleWord.toString(), temp);
                }
            }
            return new ArrayList<>(map.values());
        }
    }
}
