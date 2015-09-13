package DynamicProgrammingI;

public class UniquePathsII {
	/**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	int[][] f = new int[m][n];
    	
    	// init
    	for (int i = 0; i < m; i++) {
    		if (obstacleGrid[i][0] == 1) {
    			break;
    		}
    		f[i][0] = 1;
    	}
    	for (int j = 0; j < n; j++) {
    		if (obstacleGrid[0][j] == 1) {
    			break;
    		}
    		f[0][j] = 1;
    	}
    	
    	// loop 
    	for (int i = 1; i < m; i++) {
    		for (int j = 1; j < n; j++) {
    			if (obstacleGrid[i][j] == 1) {
    				f[i][j] = 0;
    			} else {
    				f[i][j] = f[i - 1][j] + f[i][j - 1];
    			}
    		}
    	}
    	
    	return f[m - 1][n - 1];
    	
    }

}
