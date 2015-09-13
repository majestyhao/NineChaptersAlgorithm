import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class FindPeakTest {
	FindPeak findPeak = new FindPeak();

	@Before
	public void setUp() throws Exception {
	}
	
	private void testHelper(int[] source) {
		int index = findPeak.findPeak(source);
		System.out.print(index);
		if (source[index] > source[index - 1] && source[index] > source[index + 1]) {
			return;
		} else {
			fail("Error!");
		}
	}

	@Test
	public void testFindPeak() {
		int[] source = {1, 2, 1, 3, 4, 5, 7, 6};
		testHelper(source);
		int[] source2 = {100,102,104,7,9,11,4,3};
		testHelper(source2);
	}

}
