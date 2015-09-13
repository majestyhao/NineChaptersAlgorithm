package DynamicProgrammingII;

public class InterleavingString {
	/**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
    	int m = s1.length();
    	int n = s2.length();
    	
    	if (s3.length() != m + n) {
    		return false;
    	}
    	
    	if (s3.length() == 0 && m == 0 && n == 0) {
    		return true;
    	} else if (s3.length() == 0) {
    		return false;
    	}
    	
    	if (m == 0 && n == 0) {
    		return false;
    	} else if (m == 0) {
    		for (int j = 0; j < n; j++) {
    			if (s3.charAt(j) != s2.charAt(j)) {
    				return false;
    			}
    		}
    		return true;
    	} else if (n == 0) {
    		for (int i = 0; i < m; i++) {
    			if (s3.charAt(i) != s1.charAt(i)) {
    				return false;
    			}
    		}
    		return true;
    	}
    	
    	boolean[][] f = new boolean[m + 1][n + 1];
    	f[0][0] = false;
    	
    	for (int i = 1; i < m + 1; i++) {
    		if (s1.charAt(i - 1) != s3.charAt(i - 1)) {
    			break;
    		}
    		f[i][0] = true;
    	}
    	for (int j = 1; j < n + 1; j++) {
    		if (s2.charAt(j - 1) != s3.charAt(j - 1)) {
    			break;
    		}
    		f[0][j] = true;
    	}
    	
    	// loop
    	for (int i = 1; i <= m; i++) {
    		for (int j = 1; j <= n; j++) {
    			if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1) && f[i - 1][j]) {
    				f[i][j] = true;
    			} else if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1) && f[i][j - 1]) {
    				f[i][j] = true;
    			}
    		}
    	}
    	
    	// end 
    	return f[m][n];
    	
    	// f: s1的前i个, s2的前j个, 是否interleveave s3 前i + j个  
    	/*
    	boolean [][] f = new boolean [m][n];
    	if ((s3.charAt(0) == s1.charAt(0) && s3.charAt(1) == s2.charAt(0))
    			|| ((s3.charAt(0) == s2.charAt(0) && s3.charAt(1) == s1.charAt(0)))) {
    		f[0][0] = true;
    	} else {
    		f[0][0] = false;
    	}
    	
    	// loop
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (i == 0 && j == 0)
    				continue;
    			f[i][j] = false;
    			if (i > 0 && s1.charAt(i) == s3.charAt(i + j + 1) && f[i - 1][j]) {
    				f[i][j] = true;
    			} else if (j > 0 && s2.charAt(j) == s3.charAt(i + j + 1) && f[i][j - 1]) {
    				f[i][j] = true;
    			}
    		}
    	}
    	
    	// end 
    	return f[m - 1][n - 1];
    	*/
    	
    	/*
    	 * 错的: 因为可能会把s1中和s2重复的先删掉, 打乱了s2的顺序
    	 * e.g ..df.a.df s2是dfa 但df被删掉成了adf 
    	int m = s1.length();
    	int n = s2.length();
    	
    	int cut = 0;
    	for (int i = 0; i < m; i++) {
    		for (int j = cut; j < s3.length(); j++) {
    			if (s1.charAt(i) == s3.charAt(j)) {
    				s3 = s3.substring(0, j) + s3.substring(j + 1);
    				cut = j;
    				break;
    			}
    		}
    	}
    	
    	if (s3.length() != s2.length()) {
    		return false;
    	}
    	
    	for (int i = 0; i < n; i++) {
    		if (s2.charAt(i) != s3.charAt(i)) {
    			return false;	
    			
    			}
    		}
    		
    	return true;
    	*/
    }
    

}
