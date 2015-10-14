package DynamicProgrammingII;

/**
 * Created by watershed2106 on 10/13/15.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // init
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;

        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                // deletion
                f[0][j] = f[0][j - 2];
            }
        }

        // loop
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*' ) {
                    // repetation
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        f[i][j] = f[i][j - 2] || f[i - 1][j];
                    } else {
                        // deletion
                        f[i][j] = f[i][j - 2];
                    }
                } else {
                    if (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1)) {
                        if (f[i - 1][j - 1]) {
                            f[i][j] = true;
                        }
                    }
                }
            }
        }

        return f[m][n];
    }

    public static void main(String[] args) {
        RegularExpressionMatching re = new RegularExpressionMatching();
        System.out.println(re.isMatch("aaa", "aaaa"));
    }
}
