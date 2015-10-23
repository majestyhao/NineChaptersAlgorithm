package GraphandSearch.DFS;

import org.junit.Before;
import org.junit.Test;


public class CombinationSumTest {
	CombinationSum combSum = new CombinationSum();
	int[] candidates = {2, 3, 6, 7};
	int target;

	@Before
	public void setUp() throws Exception {
		target = 7;
	}

	@Test
	public void testCombinationSum() {
		System.out.print(combSum.combinationSum(candidates, target));
	}

}
