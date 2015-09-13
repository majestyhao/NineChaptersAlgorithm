package LinkedList;

public class RmDuplicatesfromSortedList2 {
	/**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
    	if (head == null) {
    		return null;
    	}
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode pointer = head;
    	ListNode pripointer = dummy;
    	
    	while (pointer != null && pointer.next != null) {
    		if (pointer.val == pointer.next.val) {
    			if (pointer.next.next == null || pointer.next.next.val != pointer.val) {
    				pripointer.next = pointer.next.next;
    				pointer = pointer.next.next;
    			} else {
    				pointer.next = pointer.next.next;
    			}
    		} else {
    			pointer = pointer.next;
    			pripointer = pripointer.next;
    		}
    	}
    	
    	return dummy.next;
    }

}
