package DynamicProgrammingI;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MinimumPathSumTest {
	MinimumPathSum minPath = new MinimumPathSum();
	int[][] grid;

	@Before
	public void setUp() throws Exception {
		grid = new int[1][1];
		grid[0][0] = 0;
	}

	@Test
	public void testMinPathSum() {
		assertEquals(0, minPath.minPathSum(grid));
	}

}
