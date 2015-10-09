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

		// init
		boolean[][] f = new boolean[m + 1][n + 1];
		f[0][0] = true;
		for (int i = 1; i <= m; i++) {
			if (s3.charAt(i - 1) == s1.charAt(i - 1)) {
				f[i][0] = true;
			} else {
				break;
			}
		}
		for (int j = 1; j <= n; j++) {
			if (s3.charAt(j - 1) == s2.charAt(j - 1)) {
				f[0][j] = true;
			} else {
				break;
			}
		}

		// loop
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s3.charAt(i + j - 1) == s1.charAt(i - 1) && f[i - 1][j]
						|| s3.charAt(i + j - 1) == s2.charAt(j - 1) && f[i][j - 1]) {
					f[i][j] = true;
				}
			}
		}

		return f[m][n];
	}
    

}
