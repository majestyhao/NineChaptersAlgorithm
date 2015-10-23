package GraphandSearch.DFS;

import GraphandSearch.DFS.CombinationsSolution;
import org.junit.Before;
import org.junit.Test;


public class CombinationsSolutionTest {
	CombinationsSolution comSolu = new CombinationsSolution();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCombine() {
		System.out.print(comSolu.combine(4, 2));
	}

}
