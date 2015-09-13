package DynamicProgrammingII;

public class EditDistance {
	/**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
    	int m = word1.length();
    	int n = word2.length();
    	
    	if (m == 0 && n == 0) {
    		return 0;
    	} else if (m == 0) {
    		return n;
    	} else if (n == 0) {
    		return m;
    	}
    	
    	// f: 从A[0~i]变成B[0~j]需要的最小步数
    	int[][] f = new int[m][n];
    	
    	// **init
    	boolean flag = true;
    	for (int i = 0; i < m; i++) {
    		if (word1.charAt(i) == word2.charAt(0)) {
    			flag = false;
    		}
    		if (flag) {
    			f[i][0] = i + 1;
    		} else {
    			f[i][0] = i;
    		}
    	}
    	flag = true;
    	for (int j = 1; j < n; j++) {
    		if (word1.charAt(0) == word2.charAt(j)) {
    			flag = false;
    		}
    		if (flag) {
    			f[0][j] = j + 1;
    		} else {
    			f[0][j] = j;
    		}
    	}
    	
    	// loop
    	for (int i = 1; i < m; i++) {
    		for (int j = 1; j < n; j++) {
    			int edit = f[i - 1][j - 1];
    			if (word1.charAt(i) != word2.charAt(j)) {
    				edit += 1;
    			}
    			// 分别对应着A[0~i]通过del(A[i]), insert(B[j])或edit(A[i] => B[j])变成B[0~j]的步数
    			f[i][j] = Math.min(Math.min(f[i - 1][j], f[i][j - 1]) + 1, edit);
    		}
    	}
    	
    	// end
    	return f[m - 1][n - 1];
    }
}
