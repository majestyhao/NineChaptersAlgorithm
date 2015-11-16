package DynamicProgrammingII;

/**
 * Created by hao on 15-10-27.
 */
public class BestTimetoBuyandSellStockIV {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        int[] profits = prices;
        for (int i = 1; i < profits.length; i++) {
            profits[i - 1] = prices[i] - prices[i - 1];
        }

        int m = prices.length - 1;
        int n = k;

        // init, f: 前i天进行j次交易
        int[][] localMax = new int[m + 1][n + 1];
        int[][] globalMax = new int[m + 1][n + 1];

        // loop
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                localMax[i][j] = Math.max(localMax[i - 1][j],
                        globalMax[i - 1][j - 1]);
                localMax[i][j] += profits[i - 1];
                globalMax[i][j] = Math.max(globalMax[i - 1][j], localMax[i][j]);
            }
        }

        return globalMax[m][n];
    }
}
