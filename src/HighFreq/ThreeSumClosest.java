package HighFreq;

import java.util.Arrays;

public class ThreeSumClosest {
	/**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] nums ,int target) {
    	Arrays.sort(nums);
    	int cloest = Integer.MAX_VALUE;
    	int res = 0;
    	for (int i = 0; i < nums.length; i++) {
    		/*if (i != 0 && nums[i] == nums[i - 1]) {
    			continue;
    		}*/
    		for (int j = i + 1, k = nums.length - 1; j < k;) {
    			int sum = nums[i] + nums[j] + nums[k];
    			int diff = sum - target;
    			if (diff == 0) {
    				return target;
    			} else {
    				if (Math.abs(diff) < cloest) {
    					cloest = Math.abs(diff);
    					res = sum;
    				}
    				if (diff < 0) {
    					j++;
    				} else {
    					k--;
    				}
    			}
    		}
    	}
    	
    	return res;
    }

}
