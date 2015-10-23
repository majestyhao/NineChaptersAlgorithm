package GraphandSearch.DFS;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens {
	/**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
	public List<List<String>> solveNQueens(int n) {
		if (n == 1) {
			List<String> tmp = new ArrayList<String>();
			tmp.add("Q");
			List<List<String>> tmpp = new ArrayList<List<String>>();
			tmpp.add(tmp);
			return tmpp;
		}
		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(0, list, res, n);
		List<List<String>> resultStr = result2Str(res, n);
		return resultStr;
	}

	private void helper(int level, List<Integer> list, List<List<Integer>> res, int n) {
		if (level == n) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < list.size(); j++) {
				int[] twoD = oneDToTwoD(list.get(j), n);
				if (i == twoD[1] || level - i == twoD[0] - twoD[1]
						|| level + i == twoD[0] + twoD[1]) {
					flag = true;
					break;
				}
			}
			if (flag) {
				flag = false;
				continue;
			}
			list.add(twoDToOneD(level, i, n));
			helper(level + 1, list, res, n);
			list.remove(list.size() - 1);
		}
	}

	private List<List<String>> result2Str(List<List<Integer>> result, int n) {
		List<List<String>> resultStr = new ArrayList<List<String>>();
		for (int i = 0; i < result.size(); i++) {
			List<String> stringArr = new ArrayList<String>();
			for (int j = 0; j < n; j++) {
				int[] xy = oneDToTwoD(result.get(i).get(j), n);
				char[] string = new char[n];
				for (int k = 0; k < n; k++) {
					if (k == xy[1]) {
						string[k] = 'Q';
					} else {
						string[k] = '.';
					}
				}
				//System.out.println(string);
				stringArr.add(String.valueOf(string));
			}
			//System.out.print(stringArr);
			resultStr.add(stringArr);
		}
		return resultStr;
	}

	private int[] oneDToTwoD(int num, int n) {
		int[] res = new int[2];
		res[0] = num / n;
		res[1] = num % n;
		return res;
	}

	private int twoDToOneD(int x, int y, int n) {
		return x * n + y;
	}
}
