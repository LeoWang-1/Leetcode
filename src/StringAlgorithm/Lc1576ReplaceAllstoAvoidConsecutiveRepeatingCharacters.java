package StringAlgorithm;

public class Lc1576ReplaceAllstoAvoidConsecutiveRepeatingCharacters {
    class Solution {
        public String modifyString(String s) {
            // Corner case
            if (s == null || s.length() == 0) return "";
            if (s.equals("?")) return "a";

            char[] letterArray = s.toCharArray();
            for (int i = 0; i < letterArray.length; i++) {
                if (letterArray[i] == '?' && i == 0) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j != letterArray[i + 1]) {
                            letterArray[i] = j;
                            break;
                        }
                    }
                } else if (letterArray[i] == '?' && i == letterArray.length - 1) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j != letterArray[i - 1]) {
                            letterArray[i] = j;
                            break;
                        }
                    }
                } else if (letterArray[i] == '?') {
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j != letterArray[i - 1] && j != letterArray[i + 1]) {
                            letterArray[i] = j;
                            break;
                        }
                    }
                }
            }
            return new String(letterArray);
        }
    }
}
