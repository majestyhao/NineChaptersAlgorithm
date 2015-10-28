package HighFreq.TwoPointers.TwoSum;

import org.junit.Before;
import org.junit.Test;

public class TwoSumTest {
	TwoSum ts = new TwoSum();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testTwoSum() {
		int[] nums = {1, 0, -1};
		ts.twoSum(nums, -1);
	}

}
