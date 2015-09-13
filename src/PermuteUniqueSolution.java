import java.util.ArrayList;
import java.util.Arrays;

public class PermuteUniqueSolution {
	/**
	 * @param nums: A list of integers.
	 * @return: A list of unique permutations.
	 */
	public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
		if (nums == null) {
			return new ArrayList<ArrayList<Integer>>();
		}
		int[] s = new int[nums.size()];
		for (int i = 0; i < nums.size(); i++) {
			s[i] = nums.get(i);
		}
		Arrays.sort(s);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> listMap = new ArrayList<Integer>();
		permuteUniqueHelper(result, list, listMap, s);
		return result;
	}

	private void permuteUniqueHelper(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> list, ArrayList<Integer> listMap, int[] nums) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<Integer>(list));
		}
		boolean flag = false;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < listMap.size(); j++) {
				if (i == listMap.get(j)) {
					flag = true;
				}
			}
			if (i > 0 && nums[i] == nums[i - 1]) {
				for (int j = 0; j < list.size(); j++) {
					if (listMap.get(j) == i - 1) {
						flag = true;
					}
				}
			}
			if (flag) {
				flag = false;
				continue;
			}
			list.add(nums[i]);
			listMap.add(i);
			permuteUniqueHelper(result, list, listMap, nums);
			list.remove(list.size() - 1);
			listMap.remove(listMap.size() - 1);
		}
	}
}
