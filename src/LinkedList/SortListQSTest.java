package LinkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SortListQSTest {
	ListNode node0 = new ListNode(1);
	ListNode node1 = new ListNode(-1);
	SortListQS qs = new SortListQS();

	@Before
	public void setUp() throws Exception {
		node0.next = node1;
	}

	@Test
	public void testSortList() {
		ListNode result = qs.sortList(node0);
		assertEquals(-1, result.val);
		result = result.next;
		assertEquals(1, result.val);
		node0.val = 2;
		node1.val = -1;
		ListNode node2 = new ListNode(0);
		node0.next = node1;
		node1.next = node2;
		System.out.println(' ');
		result = qs.sortList(node0);
		assertEquals(-1, result.val);
		result = result.next;
		assertEquals(0, result.val);
		result = result.next;
		assertEquals(2, result.val);
		
		
		node0.val = 0;
		node1.val = 3;
		node2.val = 1;
		ListNode node3 = new ListNode(-1);
		node0.next = node1;
		node1.next = node2;
		node2.next = node3; 
		System.out.println(' ');
		result = qs.sortList(node0);
		assertEquals(-1, result.val);
		result = result.next;
		assertEquals(0, result.val);
		result = result.next;
		assertEquals(1, result.val);
		result = result.next;
		assertEquals(3, result.val);
		
		node0.val = 21;
		node1.val = 25;
		node2.val = 25;
		node3.val = 31;
		ListNode node4 = new ListNode(4);
		node0.next = node1;
		node1.next = node2;
		node2.next = node3; 
		node3.next = node4;
		System.out.println(' ');
		result = qs.sortList(node0);
		assertEquals(4, result.val);
		result = result.next;
		assertEquals(21, result.val);
		result = result.next;
		assertEquals(25, result.val);
		result = result.next;
		assertEquals(25, result.val);
		result = result.next;
		assertEquals(31, result.val);
		
		
	}

}
