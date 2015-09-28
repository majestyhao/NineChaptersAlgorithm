package HighFreq;

import java.util.ArrayList;

public class MinimumSubarray {
	/**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
    	for (int i = 0; i < nums.size(); i++) {
    		nums.set(i, -1 * nums.get(i));
    	}
    	
    	int sum = 0, minSum = 0, max = Integer.MIN_VALUE;
    	for (int i = 0; i < nums.size(); i++) {
    		sum += nums.get(i);
    		max = Math.max(max, sum - minSum);
    		minSum = Math.min(minSum, sum);
    	}
    	
    	return max;
    }

}
