import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class strStrTest {
	StrStrSolution strstr = new StrStrSolution();

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() {
		assertEquals(1, strstr.strStr("abc", "bc"));
		assertEquals(-1, strstr.strStr("abc", "ac"));
		assertEquals(1, strstr.strStr("abcbc", "bc"));
		assertEquals(2, strstr.strStr("aabcdbc", "bcd"));
		assertEquals(0, strstr.strStr("", ""));
		assertEquals(0, strstr.strStr("a", "a"));
		assertEquals(0, strstr.strStr("a", ""));
	}

}
