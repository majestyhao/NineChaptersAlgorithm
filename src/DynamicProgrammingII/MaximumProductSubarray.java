package DynamicProgrammingII;

/**
 * Created by watershed2106 on 10/19/15.
 */
public class MaximumProductSubarray {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;

        // init
        int[] f = new int[n];
        int[] localMin = new int[n];
        f[0] = nums[0];
        localMin[0] = nums[0];
        int globalMax = f[0];

        // loop
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1] * nums[i], nums[i]);
            localMin[i] = Math.min(localMin[i - 1] * nums[i], nums[i]);
            localMin[i] = Math.min(localMin[i], f[i - 1] * nums[i]);
            f[i] = Math.max(f[i], localMin[i - 1] * nums[i]);
            globalMax= Math.max(globalMax, f[i]);
        }

        return globalMax;
    }
}
