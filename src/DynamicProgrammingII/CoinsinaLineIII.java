package DynamicProgrammingII;

/**
 * Created by watershed2106 on 10/12/15.
 */
public class CoinsinaLineIII {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        int n = values.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = -1;
            }
        }

        dp[1][n] = search(1, n, dp, values);
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return dp[1][n] > sum / 2;
    }

    private int search(int x, int y, int[][] dp, int[] values) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        if (y - x < 0) {
            return 0;
        } else if (y - x == 0) {
            return values[x - 1];
        } else if (y - x == 1) {
            return Math.max(values[x - 1], values[y - 1]);
        } else {
            dp[x][y] = Math.max(Math.min(search(x + 2, y, dp, values), search(x + 1, y - 1, dp, values)) + values[x - 1],
                    Math.min(search(x + 1, y - 1, dp, values), search(x, y - 2, dp, values)) + values[y - 1]);
        }

        return dp[x][y];
    }
}
