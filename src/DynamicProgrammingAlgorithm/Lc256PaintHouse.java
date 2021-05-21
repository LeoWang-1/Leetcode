package DynamicProgrammingAlgorithm;

public class Lc256PaintHouse {
    class Solution {
        public int minCost(int[][] costs) {
            // Corner case
            if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) return 0;

            int len = costs.length;
            int[][] totalCost = new int[len][3];

            totalCost[0][0] = costs[0][0];
            totalCost[0][1] = costs[0][1];
            totalCost[0][2] = costs[0][2];

            for (int i = 1; i < len; i++) {
                // Red
                totalCost[i][0] = Math.min(totalCost[i - 1][1], totalCost[i - 1][2]) + costs[i][0];
                // Blue
                totalCost[i][1] = Math.min(totalCost[i - 1][0], totalCost[i - 1][2]) + costs[i][1];
                // Green
                totalCost[i][2] = Math.min(totalCost[i - 1][0], totalCost[i - 1][1]) + costs[i][2];
            }

            return Math.min(Math.min(totalCost[len - 1][0], totalCost[len - 1][1]), totalCost[len - 1][2]);
        }
    }
}
