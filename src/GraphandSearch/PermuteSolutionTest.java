package GraphandSearch;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class PermuteSolutionTest {
	PermuteSolution permuteSolu = new PermuteSolution();
	ArrayList<Integer> S = new ArrayList<Integer>();
	@Before
	public void setUp() throws Exception {
		S.add(1);
		S.add(2);
		S.add(3);
	}

	@Test
	public void testPermute() {
		System.out.print(permuteSolu.permute(S));
	}

}
