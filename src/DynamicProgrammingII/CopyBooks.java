package DynamicProgrammingII;

/**
 * Created by hao on 15-10-27.
 */
public class CopyBooks {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        int m = pages.length;
        int n = k;
        // init: w[i][j]从第i本书到第j本书的页数
        int[][] w = new int[m + 1][m + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                for (k = i; k <= j; k++) {
                    w[i][j] += pages[k - 1];
                }
            }
        }

        // f: i本书分配给j个人所需的最少时间
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            f[i][1] = w[1][i];
        }
        for (int i = 1; i <= m; i++) {
            // 人数
            for (int j = 2; j <= n; j++) {
                f[i][j] = Integer.MAX_VALUE;
                // 书本
                for (k = 0; k < i; k++) {
                    // 前面k本书分给j - 1个人，剩下i - k本书分给１一个人
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], w[k + 1][i]));
                }
            }
        }

        return f[m][n];
    }

    public static void main(String[] args) {
        CopyBooks cb = new CopyBooks();
        int[] tmp = {1, 2};
        cb.copyBooks(tmp, 2);
    }
}
