package GraphandSearch;

import org.junit.Before;
import org.junit.Test;


public class SolveNQueensTest {
	SolveNQueens solution = new SolveNQueens();
	

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSolveNQueens() {
		System.out.println(solution.solveNQueens(4));
		System.out.println(solution.solveNQueens(1));
		System.out.println(solution.solveNQueens(10));
	}

}
