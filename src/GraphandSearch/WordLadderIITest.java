package GraphandSearch;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class WordLadderIITest {
	WordLadderII wl2 = new WordLadderII();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindLadders() {
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("c");
		dict.add("b");
		System.out.print(wl2.findLadders("a", "c", dict));
	}

}
