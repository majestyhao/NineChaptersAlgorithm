/*
 * merge sort 
 */


package LinkedList;

public class SortListMS {
	/**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
    	if (head == null || head.next == null) {
    		return head;
    	}
    	
    	ListNode mid = findMid(head);
    	// notice here
    	ListNode right = sortList(mid.next);
    	mid.next = null;
    	ListNode left = sortList(head);
    	return merge(left, right);
    }
    
    private ListNode merge(ListNode left, ListNode right) {
    	ListNode dummy = new ListNode(0);
    	ListNode head = dummy;
    	while (left != null && right != null) {
    		if (left.val < right.val) {
    			head.next = left;
    			left = left.next;
    		} else {
    			head.next = right;
    			right = right.next;
    		}
    		head = head.next;
    	}
    	
    	//if (left.next == null) {
    	if (left == null) {
    		head.next = right;
    	} else {
    		head.next = left;
    	}
    	
    	return dummy.next;
    }
    
    private ListNode findMid(ListNode head) {
    	ListNode slow = head, fast = head.next;
    	while (fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	
    	return slow;
    }

}
