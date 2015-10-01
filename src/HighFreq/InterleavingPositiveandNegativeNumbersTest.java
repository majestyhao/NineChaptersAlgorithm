package HighFreq;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InterleavingPositiveandNegativeNumbersTest {
	InterleavingPositiveandNegativeNumbers inter;

	@Before
	public void setUp() throws Exception {
		inter = new InterleavingPositiveandNegativeNumbers();
	}

	@Test
	public void testRerange() {
		int[] nums = {-33, -19, 30, 26, 21, -9};
		inter.rerange(nums);
	}

}
