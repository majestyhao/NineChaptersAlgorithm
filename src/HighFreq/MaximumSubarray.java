package HighFreq;

import java.util.ArrayList;

public class MaximumSubarray {
	/**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(ArrayList<Integer> nums) {
    	int n = nums.size();
    	// f: the max num until nums[i];
    	int sum = 0;
    	int minSum = 0, max = Integer.MIN_VALUE;
    	// init
    	// loop: Sum - minSum, 从0到i的sum减去从0到某的minSum即从某到i的最大值 
    	for (int i = 0; i < n; i++) {
    		sum  += nums.get(i);
    		max = Math.max(max, sum - minSum);
    		minSum = Math.min(minSum, sum);
    	}
    	
    	return max;
    }

}
