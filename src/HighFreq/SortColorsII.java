package HighFreq;

public class SortColorsII {
	/**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
    	int prevPos = 0;
    	for (int i = 2; i <= k; i++) {
    		prevPos = partition(prevPos, colors.length, colors, i);
    	}
    }
    
    private int partition(int start, int end, int[] nums, int target) {
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
