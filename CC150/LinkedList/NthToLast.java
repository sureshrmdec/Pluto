package CC150.LinkedList;

/**
 * 2.2
 * Implement an algorithm to find the kth to the last element of a singly linked list.
 * k = 1, return last node, k = 2, return second to last node. Don't count from beginning !!!
 * 
 * Solution1: Recursive way. As we find the kth to the last element of list, we need recursive up to i++
 * Solution2: Iterative way. If we know list size, we just need to iterative n - k nodes.
 * 
 * 这题目就是Two Pointer, 具体的看 delete nth node in linkedlist (leetcode)
 * Recursive 的方法跟Reverse Traversal LinkedList 是一样的
 * 
 * @author jeffwan
 * @date Feb 15, 2014
 */
public class NthToLast {
	public ListNode nthToLast(ListNode head, int k) {
		return helper(head, k, 0);		
	}
	
	private ListNode helper(ListNode head, int k, int i) {
		if (head == null) {
			return null;
		}
		
		ListNode node = helper(head.next, k, i);
		// nth to last, we need condition judgement blow the recursive
		if (++i == k) {
			return head;
		}
		return node;
	}

	
	public int nthNode(ListNode head, int k) {
	    if (head == null) {
	        return -1;
	    }

	    ListNode fast = head;
	    
	    for (int i = 0; i < k; i++) {
	        if (fast.next == null) {
	            return -1;
	        }
	                    
	        fast = fast.next;
	    }
	    
	    while (fast != null) {
	        fast = fast.next;
	        head = head.next;
	    }
	    
	    return head.val;
	}
	
	// Node 
	class ListNode {
		int val;
		ListNode next;
		ListNode (int x) {
			this.val = x;
		}
	}
}
