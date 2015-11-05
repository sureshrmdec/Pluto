package com.diorsding.advance.twopointer;


/**
 * Find the Middle of Linked List.
 * 
 * 
 * Test Case:
 * 1 2 3 4 5 6 7
 * 1 2 3 4 5 6
 * 1 2 3
 * 1 2
 * 1
 * 
 * @author jiashan
 *
 */
public class FindMiddleOfLinkedList {
	
	public ListNode findMiddle(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode fast = head.next;
		ListNode slow = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	
	private class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}
}
