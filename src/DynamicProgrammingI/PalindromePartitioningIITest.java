package DynamicProgrammingI;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PalindromePartitioningIITest {
	PalindromePartitioningII palind = new PalindromePartitioningII();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMinCut() {
		assertEquals(1, palind.minCut("abb"));
		assertEquals(1, palind.minCut("cdd"));
		assertEquals(1, palind.minCut("abcccb"));
	}

}
