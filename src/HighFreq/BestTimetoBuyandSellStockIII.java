package HighFreq;

public class BestTimetoBuyandSellStockIII {
	/**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
    	if (prices.length <= 1) {
    		return 0;
    	} else if (prices.length == 2) {
    		return Math.max(0, prices[1] - prices[0]);
    	}
    	
    	for (int i = 1; i < prices.length; i++) {
    		prices[i - 1] = prices[i] - prices[i - 1];
    	}
    	
    	int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
    	int[] left = new int[prices.length - 1];
    	for (int i = 0; i < prices.length - 1; i++) {
    		sum += prices[i];
    		max = Math.max(max, sum - minSum);
    		left[i] = max;
    		minSum = Math.min(minSum, sum);
    	}
    	
    	max = Integer.MIN_VALUE; sum = 0; minSum = 0;
    	int[] right = new int[prices.length - 1];
    	for (int i = prices.length - 2; i >= 0; i--) {
    		sum += prices[i];
    		max = Math.max(max, sum - minSum);
    		right[i] = max;
    		minSum = Math.min(minSum, sum);
    	}
    	
    	max = 0;
    	for (int i = 0; i < prices.length - 2; i++) {
    		max = Math.max(max, left[i] + right[i + 1]);
    	}
     	
    	return max;
    }

}
