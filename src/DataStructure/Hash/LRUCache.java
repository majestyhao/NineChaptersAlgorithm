package DataStructure.Hash;

import java.util.HashMap;

public class LRUCache {
	class DoublyListNode {
		int key, val;
		DoublyListNode prev, next;
		DoublyListNode(int key, int val) {
			this.key = key;
			this.val = val;
			prev = null;
			next = null;
		}
	}
	
	HashMap<Integer, DoublyListNode> map = new HashMap<Integer, DoublyListNode>();
	DoublyListNode dummy, current, tail;
	int capacity;

	LRUCache(int capacity) {
		this.capacity = capacity;
		dummy = new DoublyListNode(0, 0);
		/*
		 * for (int i = 0; i < capacity; i++) { DoublyListNode node = new
		 * DoublyListNode(-1); node.prev = head; head.next = node; head =
		 * head.next; }
		 */
		tail = dummy;
	}

	// @return an integer
	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		current = map.get(key);
		if (current != tail) {
			// remove current
			current.next.prev = current.prev;
			current.prev.next = current.next;
			// move to front
			putFront(current);
		}

		return map.get(key).val;
	}

	private void putFront(DoublyListNode node) {
		tail.next = node;
		node.prev = tail;
		tail = node;
	}

	// @param key, an integer
	// @param value, an integer
	// @return nothing
	public void set(int key, int value) {
		if (get(key) != -1) {
			map.get(key).val = value;
			return;
		}
		if (map.size() == capacity) {
			// del a LRU
			map.remove(dummy.next.key);
			dummy.next = dummy.next.next;
			if (dummy.next != null) {
			dummy.next.prev = dummy;
			}
		}
		DoublyListNode node = new DoublyListNode(key, value);
		putFront(node);
		map.put(key, node);
	}

}
