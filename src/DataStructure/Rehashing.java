package DataStructure;

import LinkedList.ListNode;

public class Rehashing {
	/**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
    	int capacity = hashTable.length * 2;
    	ListNode[] newHashTable = new ListNode[capacity];
    	
    	for (int i = 0; i < hashTable.length; i++) {
    		if (hashTable[i] != null) {
    			ListNode head = hashTable[i];
    			while (head != null) {
    				ListNode node = new ListNode(head.val);
    				ListNode newHead = newHashTable[hashcode(head.val, capacity)];
    				if (newHead == null) {
    					newHashTable[hashcode(head.val, capacity)] = node;
    				} else {
    					while (newHead.next != null) {
    						newHead = newHead.next;
    					}
    					newHead.next = node;
    				}
    				head = head.next;
    			}
    		}
    	}
    	
    	return newHashTable;
    }
    
    private int hashcode(int key, int capacity) {
    	return (key % capacity + capacity) % capacity;
    }

}
