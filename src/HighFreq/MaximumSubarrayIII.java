package HighFreq;

import java.util.ArrayList;

public class MaximumSubarrayIII {
	/**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(ArrayList<Integer> nums, int k) {
    	int m = nums.size();
    	// f: 前i个数划分成j份的最大值
		int[][] f = new int[m + 1][k + 1];
		
		// init
		for (int i = 0; i <= m; i++) {
			f[i][0] = 0;
		}
		for (int j = 0; j <= k; j++) {
			f[0][j] = 0;
		}

		// f[i][j] = max_{x \in j - 1 : i}(f[x][j - 1] + maxSubArrayI_{x + 1 : i})
		// 即f[i][j]是把在0到x处划分成了j - 1份, x + 1到i是一份
		// 先算出maxSubArrI_{x : i}并存起来
		for (int j = 1; j <= k; j++) {
			// 当至少有j份时, i >= j
			for (int i = j; i <= m; i++) {
				// 从x + 2 到i时最大值
				int globalMax = Integer.MIN_VALUE, 
						// 以x为末尾, i为头的max sub array是多大
						localMax = Integer.MIN_VALUE,
							// x在不同位置时, 整体最大值
							max = Integer.MIN_VALUE;
				// 一定得倒着来, 这样才让localMax的范围是[x + 1 : i]
				for (int x = i - 1; x >= j - 1; x--) {
					localMax = Math.max(nums.get(x + 1 - 1), localMax + nums.get(x + 1 - 1));
					// nums.get(i));
					globalMax = Math.max(globalMax, localMax);
					max = Math.max(max, f[x][j - 1] + globalMax);
				}
				f[i][j] = max;
			}
		}
		
		return f[m][k];
	}

}
