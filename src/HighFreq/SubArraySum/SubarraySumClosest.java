package HighFreq.SubArraySum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SubarraySumClosest {
	/**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	if (nums.length == 1) {
    		res.add(0);
    		res.add(0);
    		return res;
    	}
    	class Pair {
    		int sum;
    		int index;
    		Pair (int sum, int index) {
    			this.sum = sum;
    			this.index = index;
    		}
    	}
    	Pair[] sum = new Pair[nums.length + 1];
    	sum[0] = new Pair(0, 0);
    	for (int i = 1; i <= nums.length; i++) {
    		sum[i] = new Pair(sum[i - 1].sum + nums[i - 1], i);
    	}
    	Arrays.sort(sum, new Comparator<Pair> () {
    		public int compare (Pair a, Pair b) {
    			return a.sum - b.sum;
    		}
    	});
    	
    	int cloest = Integer.MAX_VALUE;
    	
    	for (int i = 1; i <= nums.length; i++) {
    		if (cloest > sum[i].sum - sum[i - 1].sum) {
    			cloest = sum[i].sum - sum[i - 1].sum;
    			res.clear();
    			int[] tmp = new int[2];
    			tmp[0] = sum[i - 1].index - 1;
    			tmp[1] = sum[i].index - 1;
    			Arrays.sort(tmp);
    			res.add(tmp[0] + 1);
    			res.add(tmp[1]);
    		}
    	}
    	
    	return res;
    }

}
