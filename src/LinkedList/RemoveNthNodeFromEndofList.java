package LinkedList;

public class RemoveNthNodeFromEndofList {
	/**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head, second = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        if (first == null) {
            return head.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }
}
