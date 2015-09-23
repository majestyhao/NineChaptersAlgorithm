package DataStructure;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DataStreamMedianTest {
	DataStreamMedian ds = new DataStreamMedian();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMedianII() {
		int[] nums = {1, 2, 3, 4, 5};
		int[] result = ds.medianII(nums);
		assertEquals(1, result[0]);
		assertEquals(1, result[1]);
		assertEquals(2, result[2]);
		assertEquals(2, result[3]);
		assertEquals(3, result[4]);
	}
	

}
