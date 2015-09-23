package GraphandSearch;

import java.util.ArrayList;

public class NQueensII {
	/**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
    	if (n == 1) {
    		return 1;
    	} else if (n <= 3) {
    		return 0;
    	}
    	int[] result = new int[1];
    	result[0] = 0;
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	totalNQueensHelper(list, -1, n, result);
    	return result[0];
    }
    
    private int xy21d(int x, int y, int n) {
    	return x * n + y; 
    }
    
    private void totalNQueensHelper(ArrayList<Integer> list, int x, int n, int[] result) {
    	for (int y = 0; y < n; y++) {
    		boolean flag = false;
    		for (int k = 0; k < list.size(); k++) {
        		int lx = list.get(k) / n;
        		int ly = list.get(k) % n;
        		if (y == ly) {
        			flag = true;
        			break;
        		} else if (x - y == lx - ly) {
        			flag = true;
        			break;
        		} else if (x + y == lx + ly) {
        			flag = true;
        			break;
        		}
        	}	
    		if (flag) {
    			continue;
    		}
    		if (x == n - 1) {
    			result[0]++;
    			return;
    		}
    		int index = xy21d(x, y, n); 
    		list.add(index);
    		totalNQueensHelper(list, x + 1, n, result);
    		list.remove(list.size() - 1);
    	}
    }

}
