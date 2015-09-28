package HighFreq;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MaximumSubarrayIITest {
	MaximumSubarrayII mm;

	@Before
	public void setUp() throws Exception {
		mm = new MaximumSubarrayII();
	}

	@Test
	public void testMaxTwoSubArrays() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(-1);
		nums.add(-1);
		assertEquals(-2, mm.maxTwoSubArrays(nums));
	}

}
