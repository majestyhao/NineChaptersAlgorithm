package HighFreq;

public class SortColors {
	/**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
    	int pos1Start = partition(0, nums.length - 1, 1, nums);
    	partition(pos1Start, nums.length - 1, 2, nums);
    }
    
    private int partition(int start, int end, int target, int[] nums) {
    	int i = start, j = end;
    	while (i <= j) {
    		while (i <= j && nums[i] < target) {
    			i++;
    		}
    		while (i <= j && nums[j] >= target) {
    			j--;
    		}
    		if (i <= j) {
    			int tmp = nums[i];
    			nums[i] = nums[j];
    			nums[j] = tmp;
    			i++;
    			j--;
    		}
    	}
    	
    	return i;
    }

}
