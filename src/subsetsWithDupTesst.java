import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class subsetsWithDupTesst {
	SubsetsWithDupSolution subset = new SubsetsWithDupSolution();
	ArrayList<Integer> S = new ArrayList<Integer>();
	
	@Before
	public void setUp() throws Exception {
		S.add(1);
		S.add(2);
		S.add(2);
		//S.add(4);
		//System.out.print(S.get(0));
	}

	@Test
	public void test() {
		System.out.print(subset.subsetsWithDup(S));
	}

}
