package DynamicProgrammingII;

public class BackPackNoRecursion {
	/**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
    	int n = A.length;
    	if (n == 0 || m == 0) {
    		return 0;
    	}
    	
    	// A中前j个最大能塞容量为i的背包几何
    	int[][] f = new int[m][n];
    	// init
    	for (int j = 0; j < n; j++) {
    		if (A[j] == 1 || j > 0 && f[0][j - 1] != 0) {
    			f[0][j] = 1;
    		}
    	}
    	for (int i = A[0] - 1; i < m; i++) {
    		f[i][0] = A[0];
    	}
    	
    	// loop
    	for (int i = 1; i < m; i++) {
    		for (int j = 1; j < n; j++) {
    			// 两种情况: A[j]不放入和放入
    			// 不放人 == f[i][j - 1]
    			// 放入 == f[i - A[j]][j - 1]: 前j - 1物品放入容量为i - A[j]的背包中
    			f[i][j] = f[i][j - 1];
    			if (i - A[j] >= 0) {
    				f[i][j] = Math.max(f[i][j - 1], f[i - A[j]][j - 1] + A[j]);
    			}
    		}
    	}
    	
    	// end
    	return f[m - 1][n - 1];
    }

}
