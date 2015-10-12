package DynamicProgrammingII;

/**
 * Created by watershed2106 on 10/12/15.
 */
public class LongestIncreasingContinuoussubsequenceII {
    /**
     * @param A an integer matrix
     * @return  an integer
     */

    private int[][] dp;
    private boolean[][] flag;
    int m, n;

    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        m = A.length;

        if (m == 0) {
            return 0;
        }

        n = A[0].length;

        flag = new boolean[m][n];
        dp = new int[m][n];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = search(i, j, A);
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {1, -1, 0, 0};

    private int search(int x, int y, int[][] A) {
        if (flag[x][y]) {
            return dp[x][y];
        }

        int res = 1, nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx < m && nx >= 0 && ny < n && ny >= 0) {
                if (A[x][y] > A[nx][ny]) {
                    res = Math.max(res, search(nx, ny, A) + 1);
                }
            }
        }

        flag[x][y] = true;
        return res;
    }
}
