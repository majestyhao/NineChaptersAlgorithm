package LinkedList;

import java.util.ArrayList;

public class SortListQS {
	/**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
    	if (head == null || head.next == null) {
    		/*if (head != null)
    		System.out.println(head.val);*/
    		return head;
    	}
    	
    	return sortListHelper(head).get(0);
    }
    
    /*
     * retrun: head and tail
     */
    private ArrayList<ListNode> sortListHelper(ListNode head) {
    	ArrayList<ListNode> result = new ArrayList<ListNode>();
    	if (head == null || head.next == null) {
    		if (head != null)
    		System.out.println(head.val);
    		result.add(head);
    		result.add(head);
    		return result;
    	}
    	ListNode mid = findMed(head);
    	int tmp = mid.val;
    	mid.val = head.val;
    	head.val = tmp;
    	ArrayList<ListNode> res = partitioning(head);
    	head = res.get(0);
    	ListNode partition = res.get(1), leftTail = res.get(2);
    	System.out.print("partition: ");
    	System.out.print(partition.val);
    	System.out.println(' ');
    	ListNode tra = head;
    	while (tra != null) {
    		System.out.print(tra.val);
    		tra = tra.next;
    	}
		System.out.println(' ');
		if (leftTail != null) {
			System.out.print("cao");
			System.out.println(leftTail.val);
			leftTail.next = null;
			ArrayList<ListNode> left = sortListHelper(head);
			
			if (left.get(0) != null) {
				head = left.get(0);
			}
			
			if (left.get(1) != null) {
				System.out.print("kk");
				System.out.println(left.get(1).val);
				left.get(1).next = partition;
			} else {
				head.next = partition;
			}
			
			System.out.print("c");
			System.out.println(head.val);
			
		}
		ListNode tail = partition;
		if (partition.next != null) {
			System.out.println("mad");
			ArrayList<ListNode> right = sortListHelper(partition.next);
			ListNode pnext = right.get(0);
			partition.next = pnext;
			tail = right.get(1);
		}
    	    	    	
    	result.add(head);
    	result.add(tail);
    	tra = head;
    	while (tra != null) {
    		System.out.print(tra.val);
    		tra = tra.next;
    	}
    	System.out.println("done ");
    	return result;
    }
    
    private ListNode findMed(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ArrayList<ListNode> partitioning(ListNode head) {
    	ArrayList<ListNode> result = new ArrayList<ListNode>();
    	ListNode dummy = new ListNode(0), node2 = dummy;
    	ListNode node = head;
    	while (node != null && node.next != null) {
    		if (node.next.val < head.val) {
    			node2.next = node.next;
    			node2 = node2.next;
    			node.next = node.next.next;
    		} else {
    			node = node.next;
    		}
    	}
    	node2.next = head;
    	result.add(dummy.next); // new head 
    	result.add(head); // partitioning point 
    	if (node2 != dummy && node2.val < head.val) {
    	result.add(node2); // left tail
    	}
    	else {
    		result.add(null);
    		System.out.println("ni da ye");
    	}
    	//result.add(node); // right tail
    	
    	/* debug */
    	ListNode tra = dummy.next;
    	while (tra != null) {
    		System.out.print(tra.val);
    		tra = tra.next;
    	}
    	System.out.println(' ');
    	
    	return result;
    }

}
