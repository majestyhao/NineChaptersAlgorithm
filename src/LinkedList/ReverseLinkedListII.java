package LinkedList;

public class ReverseLinkedListII {
	/**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
    	if (m > n) {
    		return null;
    	}
    	
    	if (m == 1) {
    		return reverse(head, n);
    	}
    	
    	ListNode dummy = head;
    	for (int i = 1; head != null && i <= m - 1; i++) {
    		if (i == m - 1) {
    			head.next = reverse(head.next, n - m + 1);
    		} else {
    			head = head.next;
    		}
    	}
    	
    	return dummy;
    }
    
	private ListNode reverse(ListNode head, int n) {
		ListNode prev = head, tail = head;
		for (int i = 0; i < n; i++) {
			ListNode tmp = head.next;
			head.next = prev;
			prev = head;
			if (i != n - 1) {
				head = tmp;
			} else {
				tail.next = tmp;
			}
		}
		return head;
	}
}
