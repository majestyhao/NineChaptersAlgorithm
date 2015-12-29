package DataStructure.Hash;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	/**
	 * @param nums: A list of integers
	 * @return an integer
	 */
	public int longestConsecutive(int[] nums) {
		Set<Integer> visited = new HashSet<>();
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			visited.add(nums[i]);
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			int num = nums[i], count = 1;
			int previous = num - 1, next = num + 1;
			while (!visited.isEmpty() && visited.contains(previous)) {
				visited.remove(previous);
				previous--;
				count++;
			}
			while (!visited.isEmpty() && visited.contains(next)) {
				visited.remove(next);
				next++;
				count++;
			}
			max = Math.max(max, count);
		}

		return max;
	}

}
