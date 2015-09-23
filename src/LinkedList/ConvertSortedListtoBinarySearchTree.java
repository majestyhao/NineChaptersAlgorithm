package LinkedList;

import java.util.ArrayList;

import BinaryTreeAndDivideConquer.TreeNode;

public class ConvertSortedListtoBinarySearchTree {
	/**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {  
    	if (head == null) {
    		return null;
    	}
    	
    	ArrayList<ListNode> result = findMid(head);
    	ListNode mid = result.get(1);
    	TreeNode root = new TreeNode(mid.val);
    	ListNode midPrev = result.get(0);
    	if (midPrev != null) {
    		midPrev.next = null;
    		root.left = sortedListToBST(head);
    	} else {
    		root.left = null;
    	}
    	root.right = sortedListToBST(mid.next);
    	
    	return root;
    }
    
    private ArrayList<ListNode> findMid(ListNode head) {
    	ListNode slow = head, fast = head.next, midPrev = null;
    	ArrayList<ListNode> result = new ArrayList<ListNode>();
    	while (fast != null && fast.next != null) {
    		midPrev = slow;
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	System.out.print(head.val);
    	System.out.print('.');
    	if (midPrev != null)
    	System.out.print(midPrev.val);

    	System.out.print('.');
    	System.out.println(slow.val);
    	
    	result.add(midPrev);
    	result.add(slow);
    	return result;
    }
}
