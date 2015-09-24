package HighFreq;

import java.util.ArrayList;

public class MajorityNumberII {
	/**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
    	int count1 = 0, count2 = 0;
    	int candid1 = 0, candid2 = 0;
    	for (int i = 0; i < nums.size(); i++) {
				if (nums.get(i) == candid1) {
					count1++;
				} else if (nums.get(i) == candid2) {
					count2++;
				} else {
					if (count1 == 0) {
		    			candid1 = nums.get(i);
		    			count1++;
		    		} else if (count2 == 0) {
		    			candid2 = nums.get(i);
		    			count2++;
		    		} else {
					count1--;
					count2--;
				}
    		}
    	}
    	
    	count1 = 0; count2 = 0;
    	for (int i = 0; i < nums.size(); i++) {
    		if (nums.get(i) == candid1) {
    			count1++;
    		} else if (nums.get(i) == candid2) {
    			count2++;
    		}
    	}
    	
    	if (count1 > count2) {
    		return candid1;
    	} else {
    		return candid2;
    	}
    }

}
