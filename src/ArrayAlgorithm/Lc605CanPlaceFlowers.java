package ArrayAlgorithm;

public class Lc605CanPlaceFlowers {
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            // Corner case
            if (flowerbed == null || flowerbed.length == 0) return false;

            int maxCount = 0;
            for (int i = 0; i < flowerbed.length; i++) {
                if (flowerbed[i] == 0) {
                    int prePos = (i == 0 || flowerbed[i - 1] == 0 ) ? 0 : 1;
                    int nextPos = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) ? 0 : 1;
                    if (prePos == 0 && nextPos == 0) {
                        maxCount ++;
                        flowerbed[i] = 1;
                    }
                }
            }
            return n <= maxCount;
        }
    }
}
