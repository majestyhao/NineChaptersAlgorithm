package DynamicProgrammingI;

public class JumpGame {
	/**
	 * @param nums: A list of integers
	 * @return: The boolean answer
	 */
	public boolean canJump(int[] nums) {
		int n = nums.length;

		// init
		boolean[] f = new boolean[n + 1];
		f[0] = true;
		f[1] = true;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				if (f[j] && j + nums[j - 1] >= i) {
					f[i] = true;
					break;
				}
			}
		}

		return f[n];
	}

}
