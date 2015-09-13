import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class FindFirstBadVersionTest {
	FindFirstBadVersion findFirBad = new FindFirstBadVersion();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindFirstBadVersion() {
		//assertEquals(1, findFirBad.findFirstBadVersion(1));
		assertEquals(4, findFirBad.findFirstBadVersion(15));
	}

}
