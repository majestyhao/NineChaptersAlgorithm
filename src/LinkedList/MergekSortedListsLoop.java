package LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by watershed2106 on 10/16/15.
 */
public class MergekSortedListsLoop {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        for (int i = 0; i < lists.length; i++) {
            list.add(lists[i]);
        }

        while (list.size() > 1) {
            List<ListNode> newList = new ArrayList<ListNode>();
            for (int i = 0; i < list.size() - 1; i += 2) {
                newList.add(merge2List(list.get(i), list.get(i + 1)));
            }
            if (list.size() % 2 == 1) {
                newList.add(list.get(list.size() - 1));
            }
            list = newList;
        }

        return list.get(0);
    }

    private ListNode merge2List(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0), node = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                node.next = left;
                left = left.next;
            } else {
                node.next = right;
                right = right.next;
            }
            node = node.next;
        }

        if (left == null) {
            node.next = right;
        } else {
            node.next = left;
        }

        return dummy.next;
    }
}
