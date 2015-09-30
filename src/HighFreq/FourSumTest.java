package HighFreq;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FourSumTest {
	FourSum fs;

	@Before
	public void setUp() throws Exception {
		fs = new FourSum();
	}

	@Test
	public void testFourSum() {
		int[] nums = {1, 0, -1, -1, -1, -1, 0, 1, 1, 1, 2};
		fs.fourSum(nums, 2);
	}

}
