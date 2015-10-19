package GraphandSearch;

import org.junit.Before;
import org.junit.Test;


public class CombinationSum2Test {
	CombinationSum2 combSum2 = new CombinationSum2();
	int[] num = {10,1,6,7,2,1,5};
	int target = 8;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCombinationSum2() {
		System.out.print(combSum2.combinationSum2(num, target));
	}

}
