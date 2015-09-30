package HighFreq;

import java.util.Arrays;
import java.util.Comparator;

public class TwoSum {
	/*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
    	class Pair {
    		int index, val;
    		Pair(int index, int val) {
    			this.index = index;
    			this.val = val;		
    		}
    	}
    	   	
    	int[] res = new int[2];
    	Pair[] num = new Pair[nums.length];
    	for (int i = 0; i < nums.length; i++) {
    		num[i] = new Pair(i, nums[i]);
    	}
    	Arrays.sort(num, new Comparator<Pair>() {
    		@Override
    		public int compare(Pair a, Pair b) {
    			return a.val - b.val;
    		}
    	});
    	for (int i = 0, j = nums.length - 1; i < j;) {
    		if (num[i].val + num[j].val == target) {
    			res[0] = num[i].index + 1;
    			res[1] = num[j].index + 1;
    			Arrays.sort(res);
    			return res;
    		} else if (num[i].val + num[j].val < target) {
    			i++;
    		} else if (num[i].val + num[j].val > target) {
    			j--;
    		} 
    			
    	}
    	
    	return res;
    }

}
