package LinkedList;

public class ReverseLinkedListII {
	/**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		for (int i = 0; i < m - 1; i++) {
			head = head.next;
		}
		ListNode start = head, prev = null;
		head = head.next; ListNode rear = head;
		for (int i = m; i <= n; i++) {
			ListNode tmp = head.next;
			head.next = prev;
			prev = head;
			head = tmp;
		}
		start.next = prev;
		rear.next = head;

		return dummy.next;
	}
}
