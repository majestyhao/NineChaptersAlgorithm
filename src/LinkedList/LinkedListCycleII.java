package LinkedList;

import java.util.HashMap;

public class LinkedListCycleII {
	/**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
    	if (head == null) {
    		return null;
    	}
    	
    	HashMap<ListNode, Integer> hash = new HashMap<ListNode, Integer>();
    	
    	while (head != null) {
    		if (hash.containsKey(head)) {
    			return head;
    			
    		} else {
    			hash.put(head, 0);
    			head = head.next;
    		}
    	}
    	
    	return null;
    }

}
