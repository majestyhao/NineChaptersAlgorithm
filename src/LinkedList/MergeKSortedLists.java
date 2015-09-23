package LinkedList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	/**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
    	if (lists.size() == 0) {
    		return null;
    	}
    	
    	PQSort pqs = new PQSort();
    	PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), pqs);
    	
    	ListNode head = null;
    	for (int i = 0; i < lists.size(); i++) {
    		head = lists.get(i);
    		while (head != null) {
    			pq.add(head);
    			head = head.next;
    		}
    	}
    	
    	if (pq.isEmpty()) {
    		return null;
    	}
    	
    	ListNode dummy = pq.poll(); head = dummy;
    	while (!pq.isEmpty()) {
    		head.next = pq.poll();
    		head = head.next;
    	}
    	
    	return dummy;
    }
    
    static class PQSort implements Comparator<ListNode> {
    	public int compare(ListNode x, ListNode y) {
    			return x.val - y.val; 
    	}
    }
}
