package DynamicProgrammingI;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import java.util.HashSet;

public class WordBreakTest {
	WordBreak wb = new WordBreak();
	Set<String> dict = new HashSet<String>();

	@Before
	public void setUp() throws Exception {
		dict.add("lint");
		dict.add("code");
	}

	@Test
	public void testWordBreak() {
		wb.wordBreak("lintcode", dict);
		assertEquals(true, wb.wordBreak("lintcode", dict));
	}

}
