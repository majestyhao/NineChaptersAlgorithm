package DynamicProgrammingII;

/**
 * Created by watershed2106 on 10/19/15.
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        // init
        int[] localMax = new int[n];
        int globalMax = nums[0];
        localMax[0] = nums[0];

        // loop
        for (int i = 1; i < n; i++) {
            localMax[i] = Math.max(localMax[i - 1] + nums[i], nums[i]);
            globalMax = Math.max(globalMax, localMax[i]);
        }

        return globalMax;
    }
}
