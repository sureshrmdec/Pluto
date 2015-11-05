package com.diorsding.advance.twopointer;

/**
 * http://www.lintcode.com/en/problem/remove-nth-node-from-end-of-list/
 * Challenge: O(n) time. 
 * 
 * Test case: short 1-> null 1  ==> null.(need use dummy)   or n > list.length
 * 
 * @author jiashan
 *
 */
public class RemoveNthNodeFromEndOfList {

	ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode fast = dummy;
		ListNode slow = dummy;
		
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		slow.next = slow.next.next;
		
		return dummy.next;
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
