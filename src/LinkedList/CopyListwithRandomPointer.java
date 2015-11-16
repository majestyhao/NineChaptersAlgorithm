package LinkedList;

import java.util.HashMap;

public class CopyListwithRandomPointer {
	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	}

	/**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
    	if (head == null) {
    		return null;
    	}
    	
    	HashMap<RandomListNode, RandomListNode> hash = new HashMap<RandomListNode, RandomListNode>();  
    	RandomListNode newHead = new RandomListNode(head.label), dummy = newHead;
    	
    	hash.put(head, newHead);
    	while (head != null) {
    		if (hash.containsKey(head.next)) {
    			newHead.next = hash.get(head.next);
    		} else {
    			if (head.next == null) {
    				newHead.next = null;
    			} else {
    				newHead.next = new RandomListNode(head.next.label);
    				hash.put(head.next, newHead.next);
    			}
    		}
    		
    		if (hash.containsKey(head.random)) {
    			newHead.random = hash.get(head.random);
    		} else {
    			if (head.random == null) {
    				newHead.random = null;
    			} else {
    				newHead.random = new RandomListNode(head.random.label);
    				hash.put(head.random, newHead.random);
    			}
    		}
    		head = head.next;
    		newHead = newHead.next;
    	}
    	
    	return dummy;
    }

}
