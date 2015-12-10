package LinkedList;

import java.util.List;

/**
 * Created by hao on 15-12-9.
 */
public class MergekSortedListsRecursion {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        return mergeSort(lists, 0, lists.size() - 1);
    }

    private ListNode mergeSort(List<ListNode> lists, int start, int end) {
        if (end == start) {
            return lists.get(end);
        } else if (end < start) {
            return null;
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeSort(lists, start, mid);
        ListNode right = mergeSort(lists, mid + 1, end);

        return merge(left, right);
    }

    private ListNode merge(ListNode A, ListNode B) {
        ListNode res = new ListNode(0), head = res;
        while (A != null && B != null) {
            if (A.val < B.val) {
                head.next = A;
                A = A.next;
            } else {
                head.next = B;
                B = B.next;
            }
            head = head.next;
        }
        while (A != null) {
            head.next = A;
            head = head.next;
            A = A.next;
        }
        while (B != null) {
            head.next = B;
            head = head.next;
            B = B.next;
        }

        return res.next;
    }
}
