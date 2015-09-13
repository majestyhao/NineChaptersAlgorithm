package DynamicProgrammingI;

import java.util.ArrayList;

public class Triangle {
	/**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	if (triangle == null) {
    		return 0;
    	}
    	
    	int[][] f = new int[triangle.size()][];
    	
    	// init 
    	f[0] = new int[1];
    	f[0][0] = triangle.get(0).get(0);
    	
    	// loop
    	for (int i = 1; i < triangle.size(); i++) {
    		f[i] = new int[triangle.get(i).size()];
    		for (int j = 0; j < triangle.get(i).size(); j++) {
    			int path1 = Integer.MAX_VALUE, path2 = Integer.MAX_VALUE;
    			if (j > 0) {
    				path1 = f[i - 1][j - 1]; // left
    			} 
    			if (j < i) {
    				path2 = f[i - 1][j]; // right
    			}
    			f[i][j] = Math.min(path1, path2) + triangle.get(i).get(j);
    		}
    	}
    	
    	int min = f[f.length - 1][0];
    	for (int i = 1; i < f[f.length - 1].length; i++) {
    		if (f[f.length - 1][i] < min) {
    			min = f[f.length - 1][i];
    		}
    	}
    	
    	return min;
    }

}
