import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MergeSortedArrayTest {
	MergeSortedArray merge = new MergeSortedArray();
	int[] A, B;
	int[] A1 = {1, 3, 4, 6}, B1 = {2, 5};

	@Before
	public void setUp() throws Exception {
		A = new int[5];
		for (int i = 0; i < 3; i++) {
			A[i] = i + 1;
		}
		B = new int[2];
		B[0] = 4;
		B[1] = 5;
		
		int[] tmp = new int[6]; 
		for (int i = 0; i < A1.length; i++) {
			tmp[i] = A1[i];
		}
		A1 = tmp;
	}

	@Test
	public void testMergeSortedArray() {
		merge.mergeSortedArray(A, 3, B, 2);
		merge.mergeSortedArray(A1, 4, B1, 2);
	}

}
