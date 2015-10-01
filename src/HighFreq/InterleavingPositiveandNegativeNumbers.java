package HighFreq;

public class InterleavingPositiveandNegativeNumbers {
    /**
     * @param A: An integer array.
     * @return: void
     */
	public void rerange(int[] nums) {
		int startPos = partition(0, nums);
		//System.out.println(startPos);
		for (int i = 1, j = startPos; i < nums.length && j < nums.length;) {
			swap(i, j, nums);
			i += 2;
			j++;
		}
	}
	
	private int partition(int target, int[] nums) {
		int i = 0, j = nums.length - 1;
		while (i <= j) {                                                                                       
			while (i <= j && nums[i] < target) {
				i++;
			}
			while (i <= j && nums[j] >= target) {
				j--;
			}
			if (i <= j) {
				swap(i, j, nums);
				i++;
				j--;
			}
		}
		
		return i;		
	}
	
	private void swap(int i, int j, int[] nums) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}
