package HighFreq.TwoPointers.QuickSelect;

public class SortColors {
	/**
	 * @param nums: A list of integer which is 0, 1 or 2
	 * @return: nothing
	 */
	public void sortColors(int[] nums) {
		int i = 0, k = 0, j = nums.length - 1;
		int target = 1;
		while (i <= j) {
			if (nums[i] < target) {
				swap(nums, i, k);
				i++;
				k++;
			} else if(nums[i] == target) {
				i++;
			} else {
				swap(nums, i, j);
				j--;
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}
