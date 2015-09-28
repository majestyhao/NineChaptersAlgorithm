package HighFreq;

import java.util.ArrayList;
import java.util.HashMap;

public class MajorityNumberIII {
	/**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	
    	for (int i = 0; i < nums.size(); i++) {
    		if (map.containsKey(nums.get(i))) {
    			map.put(nums.get(i), map.get(nums.get(i)) + 1);
    		} else {
    			map.put(nums.get(i), 1);
    		}
    	}
    	
    	int counter = nums.size() / k;
    	for (int i = 0; i < nums.size(); i++) {
    		if (map.get(nums.get(i)) > counter) {
    			return nums.get(i);
    		}
    	}
    	
    	return 0;
    }

}
