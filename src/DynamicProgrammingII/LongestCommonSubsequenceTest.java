package DynamicProgrammingII;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LongestCommonSubsequenceTest {
	LongestCommonSubsequence lcs = new LongestCommonSubsequence();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLongestCommonSubsequence() {
//		assertEquals(2, lcs.longestCommonSubsequence("ABCD", "EACB"));
//		//lcs.longestCommonSubsequence("AACB", "AAAC");
//		assertEquals(3, lcs.longestCommonSubsequence("AAAC", "AACB"));
//		assertEquals(2, lcs.longestCommonSubsequence("ABCD", "EACI"));
		assertEquals(5, lcs.longestCommonSubsequence("bedaacbade", "dccaeedbeb"));
	}

}
