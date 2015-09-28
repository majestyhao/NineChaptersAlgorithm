package HighFreq;

import java.util.ArrayList;

public class BestTimetoBuyandSellStockII {
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
    	int sum = 0;
    	for (int i = 0; i < prices.length - 1; i++) {
    		sum += Math.max(prices[i], 0);
    	}
    	
    	return sum;
    }
    	/*
    	// transfer prices to profits
    	ArrayList<Integer> profits = new ArrayList<Integer>();
    	for (int i = 1; i < prices.length; i++) {
    		profits.add(prices[i] - prices[i - 1]);
    	}
    	
    	// divide and conquer
    	return maxProfitHelper(0, profits.size() - 1, profits);
    }
    
    private int maxProfitHelper(int start, int end, 
    		ArrayList<Integer> profits) {
    	// record the start point and end of max-sub-array
    	int subStart = start, tmpMin = start, subEnd = end;
    	int max = 0, sum = 0, minSum = 0;
    	for (int i = start; i < end; i++) {
    		sum += profits.get(i);
    		if (sum - minSum > max) {
    			max = sum - minSum;
    			subEnd = i;
    			subStart = tmpMin;
    		}
    		if (sum < minSum) {
    			minSum = sum;
    			tmpMin = i;
    		}
    	}
    	//ArrayList<Integer> result = new ArrayList<Integer>();
    	//result.add(subStart);
    	//result.add(subEnd);
    	//result.add(max);
    	int left, right;
    	if (subStart - start > 1) {
    		left = maxProfitHelper(start, subStart - 1, profits);
    	} else if (subStart == start) {
    		left = 0;
    	} else {
    		left = Math.max(0, profits.get(start));
    	}
    	
    	if (end - subEnd > 1) {
    		right = maxProfitHelper(subEnd + 1, end, profits);
    	} else if (end == subEnd) {
    		right = 0;
    	} else {
    		right = Math.max(0, profits.get(end));
    	}
    	
    	return left + right + max;
    }*/

}
