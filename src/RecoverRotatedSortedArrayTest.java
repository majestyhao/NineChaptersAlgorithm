import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class RecoverRotatedSortedArrayTest {
	RecoverRotatedSortedArray recov = new RecoverRotatedSortedArray();
	int[] num = {4, 5, 1, 2, 3};
	ArrayList<Integer> nums = new ArrayList<Integer>();

	@Before
	public void setUp() throws Exception {
		for (int i = 0; i < num.length; i++) {
			nums.add(num[i]);
		}
	}

	@Test
	public void testRecoverRotatedSortedArray() {
		recov.recoverRotatedSortedArray(nums);
	}

}
