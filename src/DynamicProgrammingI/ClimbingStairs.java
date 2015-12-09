package DynamicProgrammingI;

public class ClimbingStairs {
	/**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
		if (n == 0) {
			return 1;
		}
		// init
		int[] f = new int[3];
		f[0] = 1;
		f[1] = 2;

		// loop
		for (int i = 3; i <= n; i++) {
			f[(i - 1) % 3] = f[(i - 2) % 3] + f[(i - 3) % 3];
		}

		return f[(n - 1) % 3];
    }

}
