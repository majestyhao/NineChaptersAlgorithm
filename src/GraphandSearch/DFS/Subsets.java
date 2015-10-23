package GraphandSearch.DFS;

import java.util.ArrayList;
import java.util.Arrays;

class SubsetsSolution {
	/**
	 * @param S: A set of numbers.
	 * @return: A list of lists. All valid subsets.
	 */
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
		int[] s = new int[S.size()];
		for (int i = 0; i < S.size(); i++) {
			s[i] = S.get(i);
		}
		Arrays.sort(s); // 保证增序
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		subsetsHelper(result, list, 0, s);
		return result;
	}
	
	/*
	 * 把以list开头的, 且由pos后数字组成的所有子集加到result
	 * pos作为子集打头的分类(只增不减): 树杈
	 */
	private void subsetsHelper(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> list, int pos, int[] s) {
		/*ArrayList<Integer> newArray = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			newArray.add(list.get(i));
		}
		result.add(newArray);*/
		result.add(new ArrayList<Integer>(list)); // 本身加入result
		for (int i = pos; i < s.length; i++) {
			list.add(s[i]);
			//if (i < s.length) {
			subsetsHelper(result, list, i + 1, s); // 从i + 1 开始, 因为i已经用过了
			//}
			list.remove(list.size() - 1);
		}
	}
}
