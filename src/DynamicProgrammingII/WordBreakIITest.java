package DynamicProgrammingII;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by watershed2106 on 10/13/15.
 */
public class WordBreakIITest {
    private WordBreakII wb = new WordBreakII();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testWordBreakII() {
        HashSet<String> set = new HashSet<String>();
        set.add("a");
        List<String> res = wb.wordBreak("a", set);
    }
}
