package HighFreq;

import java.util.ArrayList;

public class MaximumSubarrayDifference {
	/**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
    	// A - B尽量大则A尽量大B尽量小
    	// 两种情况, 左边大右边小或者右边大左边小
    	int[] leftMax = calMaxSubArray(true, nums);
    	int[] rightMax = calMaxSubArray(false, nums);
    	
    	ArrayList<Integer> invNums = new ArrayList<Integer>();
    	for (int i = 0; i < nums.size(); i++) {
    		invNums.add(-1 * nums.get(i));
    	}
    	int[] leftMin = calMaxSubArray(true, invNums);
    	int[] rightMin = calMaxSubArray(false, invNums);
    	
    	int max = Integer.MIN_VALUE;
    	// 和maxSubArrayII类似, i作为左右分割
    	for (int i = 0; i < nums.size() - 1; i++) {
    		int lMinRMax = leftMin[i] + rightMax[i + 1];
    		int rMinLMax = rightMin[i + 1] + leftMax[i];
    		max = Math.max(max, Math.max(lMinRMax, rMinLMax));
    	}
    	
    	return max;
    }
    
    private int[] calMaxSubArray(boolean left, ArrayList<Integer> nums) {
    	int [] globalMax = new int[nums.size()];
    	int sum = 0, minSum = 0, max = Integer.MIN_VALUE;
    	if (left) {
			for (int i = 0; i < nums.size(); i++) {
				sum += nums.get(i);
				max = Math.max(max, sum - minSum);
				globalMax[i] = max;
				minSum = Math.min(minSum, sum);
			}
		} else {
			for (int i = nums.size() - 1; i >= 0; i--) {
				sum += nums.get(i);
				max = Math.max(max, sum - minSum);
				globalMax[i] = max;
				minSum = Math.min(minSum, sum);
			}
		}

    	return globalMax;
    }

}
