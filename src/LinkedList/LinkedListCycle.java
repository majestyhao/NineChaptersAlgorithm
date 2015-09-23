package LinkedList;

import java.util.HashMap;

public class LinkedListCycle {
	/**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
    	if (head == null) {
    		return false;
    	}
    	
    	HashMap<ListNode, Integer> hash = new HashMap<ListNode, Integer>();
    	
    	while (head != null) {
    		if (hash.containsKey(head)) {
    			return true;
    			
    		} else {
    			hash.put(head, 0);
    			head = head.next;
    		}
    	}
    	
    	return false;
    }

}
