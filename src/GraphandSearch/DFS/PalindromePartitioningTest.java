package GraphandSearch.DFS;

import org.junit.Before;
import org.junit.Test;

public class PalindromePartitioningTest {
	PalindromePartitioning pp = new PalindromePartitioning();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPartition() {
		System.out.println(pp.partition("aab"));
	}

}
