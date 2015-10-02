package BinarySearch;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class FindMinInRotatedSortedArrayTest {
	FindMinInRotatedSortedArray findMin = new FindMinInRotatedSortedArray();
	int[] nums = {4, 5, 6, 7, 0, 1, 2}, nums2 = {1,2,3}, nums3 = {
			266,267,268,269,271,278,282,292,293,298,6,9,15,19,21,26,
			 33,35,37,38,39,46,49,54,65,71,74,77,79,82,83,88,92,93,94,
			 97,104,108,114,115,117,122,123,127,128,129,134,137,141,142,
			 144,147,150,154,160,163,166,169,172,173,177,180,183,184,188,
			 198,203,208,210,214,218,220,223,224,233,236,241,243,253,256,257,262,263
	}; 
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindMin() {
		assertEquals(4, findMin.findMin(nums));
		assertEquals(0, findMin.findMin(nums2));
		assertEquals(10, findMin.findMin(nums3));
	}

}
