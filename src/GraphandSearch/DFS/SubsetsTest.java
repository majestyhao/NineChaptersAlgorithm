package GraphandSearch.DFS;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class SubsetsTest {
	SubsetsSolution subset = new SubsetsSolution();
	ArrayList<Integer> S = new ArrayList<Integer>();
	
	@Before
	public void setUp() throws Exception {
		S.add(4);
		S.add(1);
		S.add(0);
		//S.add(4);
		//System.out.print(S.get(0));
	}

	@Test
	public void test() {
		System.out.print(subset.subsets(S));
	}

}
