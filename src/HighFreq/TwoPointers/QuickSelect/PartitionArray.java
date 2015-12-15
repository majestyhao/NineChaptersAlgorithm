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
		int start = 0, other = start, end = nums.length - 1;
		while (start <= end) {
			if (nums[start] < k) {
				swap(nums, start, other);
				start++;
				other++;
			} else if (nums[start] == k) {
				start++;
			} else {
				swap(nums, start, end);
				end--;
			}
		}

		return other;
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}
