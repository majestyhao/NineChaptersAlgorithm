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
		int[][] f = new int[m + 1][n + 1];

		// loop
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
				int edit = f[i - 1][j - 1];
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					edit++;
				}
				f[i][j] = Math.max(edit, f[i][j]);
			}
		}

		return f[m][n];
	}

}
