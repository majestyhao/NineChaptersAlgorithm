package GraphandSearch.DFS;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class PermuteUniqueSolutionTest {
	PermuteUniqueSolution permuteUniqSolu = new PermuteUniqueSolution();
	ArrayList<Integer> S = new ArrayList<Integer>();
	@Before
	public void setUp() throws Exception {
		S.add(1);
		S.add(2);
		S.add(2);
	}

	@Test
	public void testPermuteUnique() {
		System.out.print(permuteUniqSolu.permuteUnique(S));
	}
}
