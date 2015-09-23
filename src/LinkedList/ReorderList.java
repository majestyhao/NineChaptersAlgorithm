package LinkedList;

public class ReorderList {
	/**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {  
    	if (head == null || head.next == null) {
    		return ;
    	}
    	
    	ListNode mid = findMid(head);
    	ListNode tail = reverseList(mid.next);
    	mid.next = null;
    	
    	while (head != null && tail != null) {
    		ListNode tmp = head.next, tmp2 = tail.next;
    		head.next = tail;
    		tail.next = tmp;
    		tail = tmp2;
    		head = tmp;
    	}
    	
    }
    
    private ListNode findMid(ListNode head) {
    	ListNode slow = head, fast = head.next;
    	while (fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	
    	return slow;
    }
    
    private ListNode reverseList(ListNode head) {
    	ListNode prev = null;
    	while (head != null) {
    		ListNode tmp = head.next;
    		head.next = prev;
    		prev = head;
    		head = tmp;
    	}
    	
    	return prev;
    }

}
