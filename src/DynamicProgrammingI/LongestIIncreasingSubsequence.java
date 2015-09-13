package DynamicProgrammingI;

public class LongestIIncreasingSubsequence {
	/**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {	
    	int n = nums.length;
    	
    	if (n == 0) {
    		return 0;
    	}
    	
    	// nums[i] 分为被包括在LIS和不被包括两种情况, 即LIS + 1或LIS不变
    	// 需要判断nums[i]是否应该被包含
    	// f[i]存储以nums[i]为末的LIS长度
    	int[] f = new int[n]; 
    	
    	// init 
    	f[0] = 1;
    	
    	// loop
    	// func: max(if (nums[i] >= nums[j]): f[i] = f[j] + 1)
    	for (int i = 1; i < n; i++) {
    		f[i] = 1;
    		for (int j = 0; j < i; j++) {
    			if (nums[i] >= nums[j] && f[j] >= f[i]) {
    				f[i] = f[j] + 1;
    			}
    		}
    	}
    	
    	int max = f[0];
    	for (int i = 1; i < n; i++) {
    		if (f[i] > max) {
    			max = f[i];
    		}
    	}
    	
    	// end
    	return max;
    	}

}
