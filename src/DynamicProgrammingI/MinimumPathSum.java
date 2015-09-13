package DynamicProgrammingI;

public class MinimumPathSum {
	/**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
    	// forget this
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
    	
    	int[][] f = new int[grid.length][];
    	
    	// init
    	f[0] = new int [grid[0].length];
    	f[0][0] = grid[0][0];
    	
    	// loop
    	for (int i = 0; i < grid.length; i++) {
    		if (i != 0) {
    			f[i] = new int[grid[i].length]; 
    		}
    		for (int j = 0; j < grid[i].length; j++) {
    			if (i == 0 && j == 0) {
    				continue;
    			}
    			// left && up
    			int path1 = Integer.MAX_VALUE;
    			int path2 = Integer.MAX_VALUE;
    			if (j != 0) {
    				path1 = f[i][j - 1];
    			} 
    			if (i != 0) {
    				path2 = f[i - 1][j];
    			}
    			f[i][j] = Math.min(path1, path2) + grid[i][j];
    		}
    	}
    	
    	return f[grid.length - 1][grid[0].length - 1];
    }

}
