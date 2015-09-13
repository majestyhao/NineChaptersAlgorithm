package DynamicProgrammingII;

public class BackpackII {
	/**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
    	int n = A.length;
    	if (m == 0 || n == 0) {
    		return 0;
    	}
    	
    	// f: A中前j个在容量m下时价值最大
    	int[][] f = new int[m + 1][n + 1];
    	// init
    	
    	// loop
    	for (int i = 1; i < m + 1; i++) {
    		for (int j = 1; j < n + 1; j++) {
    			f[i][j] = f[i][j - 1];
    			if (i - A[j - 1] >= 0) {
    				f[i][j] = Math.max(f[i][j - 1], f[i - A[j - 1]][j - 1] + V[j - 1]);
    			}
    		}
    	}
    	
    	// end
    	return f[m][n];
    }

}
