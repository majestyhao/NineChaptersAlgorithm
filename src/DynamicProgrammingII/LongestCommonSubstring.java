package DynamicProgrammingII;

public class LongestCommonSubstring {
	/**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
    	int m = A.length();
    	int n = B.length();
    	
    	if (m == 0 || n == 0) {
    		return 0;
    	}
    	
    	// f: 以A[i]为尾的最长序列长度
    	int[][] f = new int[m][n];
    	
    	// init
    	for (int i = 0; i < m; i++) {
    		if (B.charAt(0) == A.charAt(i)) {
    			f[i][0] = 1;
    		}
    	}
    	for (int j = 1; j < n; j++) {
    		if (A.charAt(0) == B.charAt(j)) {
    			f[0][j] = 1;
    		}
    	}
    	
    	// loop
    	for (int i = 1; i < m; i++) {
    		for (int j = 1; j < n; j++) {
    			if (A.charAt(i) == B.charAt(j)) {
    				f[i][j] = f[i - 1][j - 1] + 1; 
    			}
    		}
    	}
    	
    	// end
    	int max = f[0][0];
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (f[i][j] > max) {
    				max = f[i][j];
    			}
    		}
    	}
    	return max;
    }

}
