package DynamicProgrammingI;

/**
 * Created by watershed2106 on 10/9/15.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;

        // init
        int[] f  = new int[n];
        if (n > 0) {
            f[0] = nums[0];
        } else {
            return 0;
        }
        if (n > 1) {
            f[1] = nums[1];
        }

        // loop
        for (int i = 2; i < n; i++) {
            f[i] = Math.max(f[i - 1] - nums[i - 1] + nums[i], f[i - 2] + nums[i]);
        }

        if (n >= 2) {
            return Math.max(f[n - 1], f[n - 2]);
        } else {
            return f[0];
        }
    }
}
