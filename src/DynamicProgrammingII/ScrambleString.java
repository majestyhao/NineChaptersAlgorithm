package DynamicProgrammingII;

/**
 * Created by watershed2106 on 10/12/15.
 */
public class ScrambleString {
    /**
     * @param s1 A string
     * @param s2 Another string
     * @return whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length()) {
            return false;
        }

        // init
        boolean[][][] f = new boolean[n][n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    f[i][j][1] = true;
                }
            }
        }

        // loop
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                for (int j = 0; j < n - len + 1; j++) {
                    for (int k = 1; k < len; k++) {
                        if (f[i][j][k] && f[i + k][j + k][len - k]
                                || f[i][j + len - k][k] && f[i + k][j][len - k]) {
                            f[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }

        return f[0][0][n];
    }
}
