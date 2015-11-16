package HighFreq.TwoPointers.TwoSum;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	/**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {    	
        	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        	Arrays.sort(nums);
        	for (int i = 0; i < nums.length; i++) {
        		//if (i != nums.length - 1 && nums[i] == nums[i + 1]) {
        		//这么写是完全没有重复的, 因为后面的j是从j+1开始
        			//continue;
        		//}
        		// 这样写可能会有一个重复的元素
        		if (i != 0 && nums[i] == nums[i - 1]) {
    				continue; // to skip duplicate numbers; e.g [0,0,0,0]
    			}
        		// 因为前i个已经用过了,不能再出现了; 否则相当于重复考虑了一次
        		for (int j = i + 1, k = nums.length - 1; j < k; ) {
        			if ( nums[j] + nums[k] < -nums[i]) {
        				j++;
        			} else if (nums[j] + nums[k] > -nums[i]) {
        				k--;
        			} else {       				
        				ArrayList<Integer> res = new ArrayList<Integer>();
        				res.add(nums[i]);
        				res.add(nums[j]);
        				res.add(nums[k]);
        				result.add(res);       				
        				j++;
        				k--;
        				while (j < k && nums[j] == nums[j - 1]) { // to skip duplicates
    						j++;
    					}
    					while (j < k && nums[k] == nums[k + 1]) { // to skip duplicates
    						k--;
    					}
        				
        			}
        		}
        	}
        	
        	return result;
     }
}


