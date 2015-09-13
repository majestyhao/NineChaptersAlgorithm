package DynamicProgrammingI;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LongestIIncreasingSubsequenceTest {
	LongestIIncreasingSubsequence lis = new LongestIIncreasingSubsequence();
	int[] nums = {5, 4, 1, 2, 3};

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testLongestIncreasingSubsequence() {
		assertEquals(3, lis.longestIncreasingSubsequence(nums));
	}

}
