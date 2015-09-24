package HighFreq;

import java.util.ArrayList;
import java.util.List;

public class SingleNumberIII {
	/**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
    	int xorRes = 0;
    	for (int i = 0; i < A.length; i++) {
    		xorRes = xorRes ^ A[i];
    	}
    	
    	int lastBit = xorRes - (xorRes & (xorRes - 1));
    	int group0 = 0, group1 = 0;
    	for (int i = 0; i < A.length; i++) {
    		if ((lastBit & A[i]) == 0) {
    			group0 = group0 ^ A[i];
    		} else {
    			group1 = group1 ^ A[i];
    		}
    	}
    	
    	List<Integer> result = new ArrayList<Integer>();
    	result.add(group0);
    	result.add(group1);
    	
    	return result;
    }

}
