package HighFreq;

public class BestTimetoBuyandSellStock {
	/**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
    	if (prices.length == 0) {
    		return 0;
    	}
    	for (int i = 1; i < prices.length; i++) {
    		prices[i - 1] = prices[i] - prices[i - 1];
    	}
    	int sum = 0, minSum = 0, max = Integer.MIN_VALUE;
    	for (int i = 0; i < prices.length - 1; i++) {
    		sum += prices[i];
    		max = Math.max(max, sum - minSum);
    		minSum = Math.min(minSum, sum);
    	}
    	max = Math.max(0, max);
    	return max;
    }

}
