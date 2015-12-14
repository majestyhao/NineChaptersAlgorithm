package LinkedList;

import java.util.HashMap;

public class LinkedListCycleII {
	/**
	 * @param head: The first node of linked list.
	 * @return: The node where the cycle begins.
	 *           if there is no cycle, return null
	 */
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next==null) {
			return null;
		}

		ListNode slow = head, fast = head.next;
		while (slow != fast) {
			slow = slow.next;
			if (fast == null || fast.next == null) {
				return null;
			}
			fast = fast.next.next;
		}

		while (head != slow.next) {
			slow = slow.next;
			head = head.next;
		}

		return head;
	}

}
