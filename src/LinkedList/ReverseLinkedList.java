package LinkedList;

public class ReverseLinkedList {
	/**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
    	ListNode prior = null;
    	while (head != null) {
    		ListNode tmp = head.next;
    		head.next = prior;
    		prior = head;
    		head = tmp;
    	}
    	
    	return prior;
    }

}
