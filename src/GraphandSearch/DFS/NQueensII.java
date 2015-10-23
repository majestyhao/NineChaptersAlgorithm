package GraphandSearch.DFS;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
	/**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
	private int res = 0;

	public int totalNQueens(int n) {
		if (n == 1) {
			return 1;
		}

		List<Integer> list = new ArrayList<Integer>();
		helper(0, list, n);
		return res;
	}

	private void helper(int level, List<Integer> list, int n) {
		if (level == n) {
			res++;
			return;
		}

		for (int y = 0; y < n; y++) {
			if (!isValid(level, y, list, n)) {
				continue;
			}

			list.add(twoDToOneD(level, y, n));
			helper(level + 1, list, n);
			list.remove(list.size() - 1);
		}
	}

	private boolean isValid(int x, int y, List<Integer> list, int n) {
		for (int i = 0; i < list.size(); i++) {
			int[] xy = oneDToTwoD(list.get(i), n);
			if (y == xy[1] || x + y == xy[0] + xy[1]
					|| x - y == xy[0] - xy[1]) {
				return false;
			}
		}

		return true;
	}

	private int twoDToOneD(int x, int y, int n) {
		return x * n + y;
	}

	private int[] oneDToTwoD(int num, int n) {
		int[] res = new int[2];
		res[0] = num / n;
		res[1] = num % n;

		return res;
	}

}
