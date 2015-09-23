package DataStructure;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HeapifyTest {
	Heapify heapify;

	@Before
	public void setUp() throws Exception {
		heapify = new Heapify();
	}

	@Test
	public void testHeapify() {
		int[] A = {45, 39, 32, 11};
		heapify.heapify(A);
	}

}
