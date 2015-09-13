package DynamicProgrammingI;

public class PalindromePartitioningII {
	/**
     * @param s a string
     * @return an integer
     */
	public boolean[][] validPalind(String s) {
		// using dp to return a array can be quried at any range
		int n = s.length();
		boolean[][] f = new boolean[n][n];
		
		// init 
		for (int i = 0; i < n; i++) {
			f[i][i] = true; // single char
		}
		
		// loop
		// 从j 到 i是不是回文, 注意i和j循环顺序, 切勿造成subprob还没有求
		for (int i = 0; i < n; i++) {
			for (int j = i - 1; j >= 0 ; j--) {
				f[i][j] = false;
				f[j][i] = false;
				// 当除边界外内部是回文且边界相同时
				if ((f[i - 1][j + 1] || j + 1 == i) && s.charAt(i) == s.charAt(j)) {
					f[i][j] = true;
					f[j][i] = true;
					System.out.print(s + ": ");
					System.out.print(i);
					System.out.println(j);
				}
			}
		}
		
		return f;
	}
	
    public int minCut(String s) {
    	boolean[][] isPalind = validPalind(s);
    	int n = s.length();
    	int[] f = new int[n + 1];
    	
    	// init
    	// 对前i个字符需要至少切多少刀
    	for (int i = 0; i <= n; i++)
    		f[i] = i - 1;
    	
    	// loop
    	for (int i = 1; i <= n; i++) {
    		/* if (isPalind[i - 1][n - 1]) {
    			return;
    		} */
    		for (int j = 0; j < i; j++) {
    			// isPalind from j to i and is min
    			if (isPalind[j][i - 1] && f[j] < f[i]) {
    				f[i] = f[j] + 1;
    			}
    		}
    	}
    	
    	// end
    	return f[n];
    }

}
