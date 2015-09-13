package DynamicProgrammingI;

public class UniquePaths {
	/**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
    	int[][] f = new int[m][n];
    	
    	// init
    	f[0][0] = 1;
    	for (int i = 1; i < m; i++) {
    		f[i][0] = 1;
    	}
    	for (int j = 1; j < n; j++) {
    		f[0][j] = 1;
    	}
    	
    	// loop
    	for (int i = 1; i < m; i++) {
    		for (int j = 1; j < n; j++) {
    			f[i][j] = f[i - 1][j] + f[i][j - 1];
    		}
    	}
    	
    	// end
    	return f[m - 1][n - 1];
    }

}
