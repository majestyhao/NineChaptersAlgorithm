package DynamicProgrammingII;

public class LongestCommonSubsequence {
	/**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
    	int m = A.length();
    	int n = B.length();
    	
    	if (m == 0 || n == 0) {
    		return 0;
    	}
    	
    	// f: A前i, 与B的前j个字符相匹配的LCS 
    	int[][] f = new int[m][n];
    	// init
    	for (int i = 0; i < m; i++) {
    		if (B.charAt(0) == A.charAt(i) || i > 0 && f[i - 1][0] != 0) {
    			f[i][0] = 1;
    		}
    	}
    	
    	for (int j = 1; j < n; j++) {
    		if (A.charAt(0) == B.charAt(j) || f[0][j - 1] != 0) {
    			f[0][j] = 1;
    		}
    	}
    	
    	// loop
    	for (int i = 1; i < m; i++) {
    		for (int j = 1; j < n; j++) {
    			// f[i][j]至少为f[i-1][j]和f[i][j-1]
    			f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
    			if (A.charAt(i) == B.charAt(j)) {
    				// ****notice this: 相当于比f[i-1][j-1]多了一个相同的元素
    				f[i][j] = f[i - 1][j - 1] + 1;
    			} 
    		}
    	}
    	
    	// end
    	return f[m - 1][n - 1];
    }

}
