package DynamicProgrammingII;

import java.util.Arrays;

/**
 * Created by hao on 15-10-27.
 */
public class PostOfficeProblem {
    /**
     * @param nums an integer array
     * @param k an integer
     * @return an integer
     */
    public int postOffice(int[] nums, int k) {
        int m = nums.length;
        if (m == 0) {
            return 0;
        }
        int n = k;
        Arrays.sort(nums);
        // w: 从i到j房子离邮局最短的总距离
        // 邮局在一个区间中点时，总距离最短
        int[][] w = new int[m + 1][m + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                int mid = i + (j - i) / 2;
                for (k = i; k <= j; k++) {
                    w[i][j] += Math.abs(nums[k - 1] - nums[mid - 1]);
                }
            }
        }


        // f: 前i个房子放置k个post office
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i<= m; i++) {
            f[i][1] = w[1][i];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                f[i][j] = Integer.MAX_VALUE;
                for (k = 0; k < i; k++) {
                    f[i][j] = Math.min(f[i][j], f[k][j - 1] + w[k + 1][i]);
                }
            }
        }

        return f[m][n];
    }
}
