package HighFreq.TwoPointers.TwoSum;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
	/**
     * @param numbers : Give an array numbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) { 
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length; i++) {
    		if (i != 0 && nums[i] == nums[i - 1]) {
    			continue;
    		}
    		for (int j = i + 1; j < nums.length; j++) {
    			// notice here j != i + 1
    			if (j != i + 1 && nums[j] == nums[j - 1]) {
    				continue;
    			}
    			for (int k = j + 1, p = nums.length - 1; k < p;) {
    				if (nums[i] + nums[j] + nums[k] + nums[p] == target) {
    					ArrayList<Integer> res = new ArrayList<Integer>();
    					res.add(nums[i]);
    					res.add(nums[j]);
    					res.add(nums[k]);
    					res.add(nums[p]);
    					k++;
    					p--;
    					result.add(res);
    					while (k < p && nums[k] == nums[k - 1]) {
    						k++;
    					}
    					while (k < p && nums[p] == nums[p + 1]) {
    						p--;
    					}
    				} else if (nums[i] + nums[j] + nums[k] + nums[p] < target) {
    					k++;
    				} else {
    					p--;
    				}
    			}
    		}
    	}
    	
    	return result;
    }


}
