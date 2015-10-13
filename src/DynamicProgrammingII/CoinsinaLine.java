package DynamicProgrammingII;

/**
 * Created by watershed2106 on 10/12/15.
 */
public class CoinsinaLine {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        int[] dp = new int[n + 1];

        return search(n, dp);
    }

    private boolean search(int n, int[] dp) {
        // 搜索过的点, 0 代表没搜索过， 1代表F, 2 代表T
        if (dp[n] != 0) {
            return dp[n] != 1;
        } else if (n <= 0) {
            dp[n] = 1;
        } else if (n == 1) {
            dp[n] = 2;
        } else if (n == 2) {
            dp[n] = 2;
        } else if (n == 3) {
            dp[n] = 1;
        } else {
            if (search(n - 2, dp) && search(n - 3, dp) ||
                    search(n - 3, dp) && search(n - 4, dp)) {
                dp[n] = 2;
            } else {
                dp[n] = 1;
            }
        }

        return dp[n] == 2;
    }
}
