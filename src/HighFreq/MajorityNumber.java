package HighFreq;

import java.util.ArrayList;

public class MajorityNumber {
	/**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
    	if (nums.size() == 0) {
    		return -1;
    	}
    	
    	int count = 0, majNum = 0;
    	for (int i = 0; i < nums.size(); i++) {
    		if (count == 0) {
    			majNum = nums.get(i);
    			count++;
    		} else if (nums.get(i) == majNum) {
    			count++;
    		} else {
    			count--;
    		}
    	}
    	
    	return majNum;
    }

}
