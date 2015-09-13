package LinkedList;

public class RemoveDuplicatesfromSortedList {
	    /**
	     * @param ListNode head is the head of the linked list
	     * @return: ListNode head of linked list
	     */
	    public static ListNode deleteDuplicates(ListNode head) { 
	    	if (head == null) {
	    		return null;
	    	}
	    	
	    	ListNode dummy = head;
	    	
	    	while (head.next != null) {
	    		if (head.val == head.next.val) {
	    			head.next = head.next.next;
	    		} else {
	    		head = head.next;
	    		}
	    	}
	    	
	    	return dummy;
	    }  
}
