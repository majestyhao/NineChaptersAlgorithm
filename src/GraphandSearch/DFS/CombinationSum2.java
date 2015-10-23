package GraphandSearch.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	/**
	 * @param num: Given the candidate numbers
	 * @param target: Given the target number
	 * @return: All the combinations that sum to target
	 */
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		if (num == null || target < 1) {
			return new ArrayList<List<Integer>>();
		}
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		combinationSum2Helper(result, list, 0, num, target);
		return result;
	}

	private void combinationSum2Helper(List<List<Integer>> result,
			List<Integer> list, int pos, int[] nums, int target) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		if (sum == target) {
			for (int i = 0; i < result.size(); i++) {
				if (list.equals(result.get(i))) {
					return;
				}
			}
				result.add(new ArrayList<Integer>(list));
		} else if (target < sum) {
			return;
		}
		for (int i = pos; i < nums.length; i++) {
			list.add(nums[i]);
			combinationSum2Helper(result, list, i + 1, nums, target); // notice here
			list.remove(list.size() - 1);
		}
	}
}
