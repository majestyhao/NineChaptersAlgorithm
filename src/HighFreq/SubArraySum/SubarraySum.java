package HighFreq.SubArraySum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
	/**
	 * @param nums: A list of integers
	 * @return: A list of integers includes the index of the first number
	 *          and the index of the last number
	 */
	public ArrayList<Integer> subarraySum(int[] nums) {
		Map<Integer, Integer> preSum = new HashMap<>();
		ArrayList<Integer> res = new ArrayList<>();
		preSum.put(0, -1); // to handle cases like [-1, 1]
		for (int i = 0, sum = 0; i < nums.length; i++) {
			sum += nums[i];
			if (preSum.containsKey(sum)) {
				res.add(preSum.get(sum) + 1);
				res.add(i);
				return res;
			} else {
				preSum.put(sum, i);
			}
		}

		return res;
	}

}
