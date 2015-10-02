package BinarySearch;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SearchInRotatedSortedArrayTest {
	SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
	int[] nums = {1,2,3,4,5,9};

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSearch() {
		assertEquals(5, search.search(nums, 9));
	}

}
