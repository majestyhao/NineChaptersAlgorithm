package DynamicProgrammingII;

public class DistinctSubsequences {
	/**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
    	int m = S.length();
    	int n = T.length();
    	
    	if (m == 0 || n == 0) {
    		return 0;
    	}
    	// f: S中前i个中包含多少唯一的T中前j个组成的字符串
    	int [][] f = new int[m][n];
    	
    	// init 
    	int count = 0;
    	for (int i = 0; i < m; i++) {
    		if (S.charAt(i) == T.charAt(0)) {
    			count++;
    		}
    		f[i][0] = count;
    	}
    	
    	
    	// loop
    	for (int i = 1; i < m; i++) {
    		for (int j = 1; j < n; j++) {
    			// f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
    			if (S.charAt(i) == T.charAt(j)) {
    				// **分别为: 1. 选择S[i]作为T[j]的匹配 2. 选择S[0:i-1]作为T[0:j]的匹配, 不选择S[i]
    				f[i][j] = f[i - 1][j - 1] + f[i - 1][j]; 
    			} else {
    				f[i][j] = f[i - 1][j]; 
    			}
    		}
    	}
    	
    	// end 
    	return f[m - 1][n - 1];
    }
    
}
