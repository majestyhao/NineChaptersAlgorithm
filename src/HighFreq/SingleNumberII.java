package HighFreq;

import java.util.ArrayList;

public class SingleNumberII {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public int singleNumberII(int[] A) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	for (int i = 0; i < A.length; i++) {
    		ArrayList<Integer> num = deci2tern(A[i]);
    		result = XOR3(result, num);
    	}
    	
    	return tern2deci(result);
    }
    
    public int tern2deci(ArrayList<Integer> tern) {
    	int result = 0;
    	for (int i = 0; i < tern.size(); i++) {
    		result += Math.pow(3, i) * tern.get(i);
    	}
    	
    	return result;
    }
    
    public ArrayList<Integer> deci2tern(int num) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	while (num >= 3) {
    		result.add(num % 3);
    		num = num / 3;
    	}
    	result.add(num);
    	return result;
    }
    
    public ArrayList<Integer> XOR3(ArrayList<Integer> op1, ArrayList<Integer> op2) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	for (int i = 0; i < op1.size() && i < op2.size(); i++) {
    		if (op1.get(1) + op2.get(2) == 3) {
    			result.add(0);
    		} else {
    			result.add(op1.get(1) + op2.get(2));
    		}
    	}
    	int diff = 0; ArrayList<Integer> op = op1; int start = op2.size() + 1;
    	if (op1.size() > op2.size()) {
    		diff = op1.size() - op2.size();
    	} else {
    		diff = op2.size() - op1.size();
    		op = op2;
    		start = op1.size() + 1;
    	}
    	
    	for (int j = start; j < diff ; j++) {
			result.add(op.get(j));
		}
    	
    	return result;
    }

}
