package HighFreq;

import java.util.ArrayList;
import java.util.HashMap;

public class SubarraySum {
	/**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	int sum = 0;
    	for (int i = 0; i < nums.length; i++) {
    		sum += nums[i];
    		if (sum == 0) {
    			result.add(0);
    			result.add(i);
    			return result;
    		}
    		if (map.containsKey(sum)) {
    			result.add(map.get(sum) + 1);
    			result.add(i);
    			return result;
    		}
    		map.put(sum, i);
    	}
    	
    	return result;
    }

}
