package DynamicProgrammingII;

/**
 * Created by watershed2106 on 10/12/15.
 */
public class CoinsinaLineII {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        int n = values.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = -1;
        }
        int res = search(n, dp, values);
        return res > sum / 2;
    }

    private int search(int n, int[] dp, int[] values) {
        if (dp[n] != -1) {
            return dp[n];
        }

        int res = 0;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return values[0];
        } else if (n == 2) {
            return values[0] + values[1];
        } else if (n == 3) {
            return values[0] + values[1];
        } else {
            int len = values.length;
            res = Math.max(Math.min(search(n - 2, dp, values), search(n - 3, dp, values)) + values[len - n],
                    Math.min(search(n - 3, dp, values), search(n - 4, dp, values)) + values[len - n] + values[len - n + 1]);
        }
        dp[n] = res;
        return res;
    }
}
