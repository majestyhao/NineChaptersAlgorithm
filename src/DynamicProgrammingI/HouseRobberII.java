package DynamicProgrammingI;

/**
 * Created by watershed2106 on 10/9/15.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        int max = -1;

        // init
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] f  = new int[n - 1];
        f[0] = nums[0];
        f[1] = nums[1];


        // loop
        for (int i = 2; i < n - 1; i++) {
            f[i] = Math.max(f[i - 1] - nums[i - 1] + nums[i], f[i - 2] + nums[i]);
        }
        max = Math.max(f[n - 2], f[n - 3]);

        // loop
        f  = new int[n - 1];
        f[0] = nums[1];
        f[1] = nums[2];


        for (int i = 2; i < n - 1; i++) {
            f[i] = Math.max(f[i - 1] - nums[i] + nums[i + 1], f[i - 2] + nums[i + 1]);
        }

        int tmp = Math.max(f[n - 2], f[n - 3]);
        max = Math.max(max, tmp);

        return max;
    }
}
