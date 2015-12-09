package DynamicProgrammingII;

public class EditDistance {
	/**
	 * @param word1 & word2: Two string.
	 * @return: The minimum number of steps.
	 */
	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();

		// init
		int[][] f = new int[m + 1][n + 1];
		f[0][0] = 0;
		for (int i = 1; i <= m; i++) {
			f[i][0] = i;
		}
		for (int j = 1; j <= n; j++) {
			f[0][j] = j;
		}

		// loop
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				int edit = f[i - 1][j - 1];
				if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
					edit += 1;
				}
				f[i][j] = Math.min(edit, Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1));
			}
		}

		return f[m][n];
	}
}
