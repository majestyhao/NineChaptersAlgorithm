/*
 * Sorting list using PQ
 * Memory limit exceed..
 */

package LinkedList;

import java.util.PriorityQueue;
import java.util.Comparator;

public class SortList {
	/**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
    	if (head == null) {
    		return null;
    	}
    	
    	PQSort pqs = new PQSort();
    	PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(10, pqs);
    	
    	while (head != null) {
    		pq.add(head);
    	}
    	
    	head = pq.poll();
    	ListNode dummy = head;
    	while (!pq.isEmpty()) {
    		head.next = pq.poll();
    		head = head.next;
    	}
    	
    	return dummy;
    }
    
    static class PQSort implements Comparator<ListNode> {
    	public int compare(ListNode x, ListNode y) {
    			return y.val - x.val; 
    	}
    }
    
}
