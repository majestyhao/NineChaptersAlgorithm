package HighFreq.SubArraySum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SubarraySumClosest {
	/**
	 * @param nums: A list of integers
	 * @return: A list of integers includes the index of the first number
	 *          and the index of the last number
	 */
	public int[] subarraySumClosest(int[] nums) {
		int n = nums.length;
		SumElement[] sums = new SumElement[n];

		for (int i = 0, sum = 0; i < n; i++) {
			sum += nums[i];
			sums[i] = new SumElement(sum, i);
		}

		Arrays.sort(sums, new SumElementComparator());
		int min = Integer.MAX_VALUE;
		int[] res = new int[2];
		for (int i = 1; i < n; i++) {
			if (sums[i].sum - sums[i - 1].sum < min) {
				if (sums[i - 1].index < sums[i].index) {
					res[0] = sums[i - 1].index + 1;
					res[1] = sums[i].index;
				} else {
					res[0] = sums[i].index + 1;
					res[1] = sums[i - 1].index;
				}
				min = sums[i].sum - sums[i - 1].sum;
			}
		}

		return res;
	}

	class SumElement {
		int sum;
		int index;
		SumElement(int sum, int index) {
			this.sum = sum;
			this.index = index;
		}
	}

	class SumElementComparator implements Comparator<SumElement> {
		public int compare(SumElement a, SumElement b) {
			return a.sum - b.sum;
		}
	}

}
