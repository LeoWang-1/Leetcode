package DfsAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Lc93RestoreIPAddresses {
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            // Corner case
            if (s == null || s.length() == 0 || s.length() < 4) return new ArrayList<>();

            List<String> allValidIpAddresses = new ArrayList<>();
            findRestoreIpAddresses(allValidIpAddresses, new StringBuilder(), 0, 0, s);

            return allValidIpAddresses;
        }

        private void findRestoreIpAddresses(List<String> allValidIpAddresses, StringBuilder singlePath, int num, int index, String input) {
            // Base case
            if (num == 4 && index == input.length()) {
                allValidIpAddresses.add(String.valueOf(singlePath));
                return;
            }
            if (num == 4 && index < input.length()) return;

            // Next step
            int len = singlePath.length();
            for (int i = 1; i <= 3; i++) {
                if (index + i > input.length()) break;
                int value = Integer.valueOf(input.substring(index, index + i));
                if (value >= 0 && value <= 255) {
                    if (singlePath.length() == 0) {
                        singlePath.append(value);
                    } else {
                        singlePath.append("." + value);
                    }
                    findRestoreIpAddresses(allValidIpAddresses, singlePath, num + 1, index + i, input);
                    singlePath.setLength(len);
                }

                if (value == 0) break;
            }
        }
    }
}
