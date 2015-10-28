package HighFreq.TwoPointers.QuickSelect;

public class PartitionArray {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
	public int partitionArray(int[] nums, int k) {
		if (nums.length == 0) {
			return 0;
		}
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			while (left <= right && nums[left] < k) {
				left++;
			}
			while (left <= right && nums[right] >= k) {
				right--;
			}
			if (left <= right) {
				swap(left, right, nums);
			}
		}

		return left;
	}

	private void swap(int i, int j, int[] nums) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}
