package DynamicProgrammingI;

import java.util.ArrayList;

public class Triangle {
	/**
	 * @param triangle: a list of lists of integers.
	 * @return: An integer, minimum path sum.
	 */
	public int minimumTotal(int[][] triangle) {
		int m = triangle.length;

		// init
		int[] f = new int[1];
		f[0] = triangle[0][0];

		// loop
		for (int i = 1; i < m; i++) {
			int n = triangle[i].length;
			int[] nf = new int[n];
			for (int j = 1; j < n - 1; j++) {
				nf[j] = Math.min(f[j], f[j - 1]) + triangle[i][j];
			}
			nf[0] = f[0] + triangle[i][0];
			if (n > 1) {
				nf[n - 1] = f[n - 2] + triangle[i][n - 1];
			}
			f = nf;
		}

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			res = Math.min(res, f[i]);
		}

		return res;
	}

}
