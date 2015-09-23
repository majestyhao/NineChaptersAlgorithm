package HighFreq;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SingleNumberIITest {
	SingleNumberII sn = new SingleNumberII();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSingleNumberII() {
		int[] A = {1,1,2,3,3,3,2,2,4,1};
		//assertEquals(4, sn.singleNumberII(A));
	}


	@Test
	public void testDeci2tern() {
		ArrayList<Integer> result = sn.deci2tern(3);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
		assertEquals(3, sn.tern2deci(result));
		result = sn.deci2tern(8);
		assertEquals(8, sn.tern2deci(result));
		result = sn.deci2tern(18);
		assertEquals(18, sn.tern2deci(result));
		result = sn.deci2tern(42);
		assertEquals(42, sn.tern2deci(result));
		result = sn.deci2tern(1230);
		assertEquals(1230, sn.tern2deci(result));
	}

	@Test
	public void testXOR3() {
		ArrayList<Integer> op1 = sn.deci2tern(3);
		ArrayList<Integer> op2 = sn.deci2tern(3);
		ArrayList<Integer> op3 = sn.deci2tern(3);
		ArrayList<Integer> result = sn.XOR3(op1, op2);
		result = sn.XOR3(result, op3);
		assertEquals(0, sn.tern2deci(result));
	}

}
