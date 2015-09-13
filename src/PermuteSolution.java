import java.util.ArrayList;

public class PermuteSolution {
	/**
	 * @param nums: A list of integers.
	 * @return: A list of permutations.
	 */
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
		if (nums == null) {
			// forgot this
			return new ArrayList<ArrayList<Integer>>();
		}
		int[] s = new int[nums.size()];
		for (int i = 0; i < nums.size(); i++) {
			s[i] = nums.get(i);
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		permuteHelper(result, list, s); // list相當於起了pos的分類作用
		return result;
	}

	private void permuteHelper(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> list, int[] nums) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<Integer>(list));
		}
		boolean flag = false;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < list.size(); j++) {
				if (nums[i] == list.get(j)) {
					flag = true;
				}
			}
			if (flag) {
				flag = false;
				continue;
			}
			list.add(nums[i]);
			permuteHelper(result, list, nums);
			list.remove(list.get(list.size() - 1));
		}
	}
}
