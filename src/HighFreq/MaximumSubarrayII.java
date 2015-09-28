package HighFreq;

import java.util.ArrayList;

public class MaximumSubarrayII {
	 /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
    	int max = Integer.MIN_VALUE;
    	/*
    	// outer loop as separator
    	for (int i = 0; i < nums.size(); i++) {
    		int sum1 = 0, sum2 = 0, minSum1 = 0, minSum2 = 0;
        	int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        			
    		for (int j = 0; j < i; j++) {
    			sum1 += nums.get(j);
    			max1 = Math.max(max1, sum1 - minSum1);
    			minSum1 = Math.min(minSum1, sum1);
    		}
    		for (int k = i; k < nums.size(); k++) {
    			sum2 += nums.get(k);
    			max2 = Math.max(max2, sum2 - minSum2);
    			minSum2 = Math.min(minSum2, sum2);
    		}
    		if (max1 == Integer.MIN_VALUE || max2 == Integer.MIN_VALUE) {
    			continue;
    		}
    		//System.out.println(max1);
    		//System.out.println(max2);
    		//System.out.println(max1 + max2);
    		max = Math.max(max, max1 + max2);
    		//System.out.println(max);
    	}*/
    	int sum = 0, minSum = 0;
    	int[] left = new int[nums.size()];
    	// from left to right 
    	for (int i = 0; i < nums.size(); i++) {
    		sum += nums.get(i);
    		max = Math.max(max, sum - minSum);
    		left[i] = max;
    		minSum = Math.min(sum, minSum);
    	}
    	
    	int[] right = new int[nums.size()];
    	sum = 0; minSum = 0;
    	max = Integer.MIN_VALUE;
    	// from right to left
    	for (int i = nums.size() - 1; i >= 0; i--) {
    		sum += nums.get(i);
    		max = Math.max(max, sum - minSum);
    		right[i] = max;
    		minSum = Math.min(sum, minSum);
    	}
    	
    	max = Integer.MIN_VALUE;
    	for (int i = 0; i < nums.size() - 1; i++) {
    		max = Math.max(max, left[i] + right[i + 1]);
    	}
    	
    	
    	return max;
    }

}
