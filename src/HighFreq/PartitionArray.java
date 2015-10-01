package HighFreq;

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
    	int i, j;
    	// 最后i比j多一位
    	for (i = 0, j = nums.length - 1; i <= j;) {
    		while (i <= j && nums[i] < k) {
    			i++;
    		}
    		while (i <= j && nums[j] >= k) {
    			j--;                                                                                                                                          
    		}
    		//swap()
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
