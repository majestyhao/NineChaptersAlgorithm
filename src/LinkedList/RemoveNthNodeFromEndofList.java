package LinkedList;

public class RemoveNthNodeFromEndofList {
	/**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
    	if (head == null || n < 0) {
    		return null;
    	} 
    	
    	ListNode dummy = head;
    	
    	int len = getLength(head);
    	
    	if (len - n == 0) {
    		return head.next;
    	}
    	for (int i = 0; i < len - n - 1; i++) {
    		head = head.next;
    	}
    	head.next = head.next.next;
    	
    	return dummy;
    }
    
    private int getLength(ListNode head) {
    	int count = 0;
    	while (head != null) {
    		head = head.next;
    		count++;
    	}
    	
    	return count;
    }

}
