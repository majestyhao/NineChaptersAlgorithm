import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class FindMedianSortedArraysDoAgainTest {
	FindMedianSortedArraysDoAgain findMed = new FindMedianSortedArraysDoAgain();
	int[] A10 = {1, 2}, B10 = {3, 4, 5, 6, 7}; 
	int[] A11 = {1, 2, 3, 4, 5}, B11 = {6, 7, 8, 9, 10, 11}; 

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindMedianSortedArrays() {
		assertEquals(6, findMed.findMedianSortedArrays(A11, B11), 0);
	}

	@Test
	public void testFindKth() {
		assertEquals(6, findMed.findKth(A10, 0, B10, 0, 6));
	}

}
