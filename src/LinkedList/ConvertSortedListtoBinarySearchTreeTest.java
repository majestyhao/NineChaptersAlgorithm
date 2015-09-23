package LinkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConvertSortedListtoBinarySearchTreeTest {
	ConvertSortedListtoBinarySearchTree conv = new ConvertSortedListtoBinarySearchTree();
	ListNode node0, node1, node2, node3;
	
	@Before
	public void setUp() throws Exception {
		node0 = new ListNode(-1);
		node1 = new ListNode(0);
		node2 = new ListNode(1);
		node3 = new ListNode(3);
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		
	}

	@Test
	public void testSortedListToBST() {
		conv.sortedListToBST(node0);
		
	}

}
