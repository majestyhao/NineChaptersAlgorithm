package DataStructure.Hash;

import java.util.HashSet;

public class LongestConsecutiveSequence {
	/**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
    	HashSet<Integer> set = new HashSet<Integer>();
    	for (int i = 0; i < num.length; i++) {
    		if (set.contains(num[i])) {
    			continue;
    		}
    		set.add(num[i]);
    	}
    	
    	int max = 1;
    	HashSet<Integer> met = new HashSet<Integer>();
    	for (int i = 0; i < num.length; i++) {
    		if (met.contains(num[i])) {
    			continue;
    		}
    		met.add(num[i]);
    		int tmp = num[i];
    		int count = 1;
    		while (set.contains(tmp - 1)) {
    			met.add(tmp - 1);
    			tmp = tmp - 1;
    			count++;
    		}
    		tmp = num[i];
    		while (set.contains(tmp + 1)) {
    			met.add(tmp + 1);
    			tmp = tmp + 1;
    			count++;
    		}
    		if (count > max) {
    			max = count;
    		}
    	}
    	
    	return max;
    }	

}
