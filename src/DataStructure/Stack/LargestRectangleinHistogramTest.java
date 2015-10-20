package DataStructure.Stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LargestRectangleinHistogramTest {
	LargestRectangleinHistogram largeRect = new LargestRectangleinHistogram();
	int[] test = {1, 1};
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLargestRectangleArea() {
		assertEquals(2, largeRect.largestRectangleArea(test));
	}

}
