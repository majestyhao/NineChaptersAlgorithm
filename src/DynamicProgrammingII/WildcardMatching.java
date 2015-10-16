package DynamicProgrammingII;

/**
 * Created by watershed2106 on 10/15/15.
 */
public class WildcardMatching {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // init
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                f[0][j] = f[0][j - 1];
            }
        }

        // loop
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // deletion
                    f[i][j] = f[i - 1][j - 1] || f[i - 1][j] || f[i][j - 1];
                } else {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }

        return f[m][n];
    }
}
