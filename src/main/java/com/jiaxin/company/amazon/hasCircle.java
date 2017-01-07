package com.jiaxin.company.amazon;

public class hasCircle {

	/**
	 * If there's cycle in a linkedList, slow and fast must meet at somewhere in the cycle.
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		
		do {
			if (fast.next == null || fast.next.next == null) {
				return false;
			}
			
			slow = slow.next;
			fast = fast.next;
		} while (slow != fast);
		
		return true;
	}
	
	/**
	 * After slow pointer and fast pointer meets first time, slow and head moves forward together, 
	 * The position they meet are the entry of the cycle.
	 * 
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		
		do {
			if (fast.next == null || fast.next.next == null) {
				return null;
			}
			
			slow = slow.next;
			fast = fast.next;
		} while (slow != fast);
		
		
		while(slow != head) {
			slow = slow.next;
			head = head.next;
		}
		
		return head;
	}
	
	
	class ListNode {
		int val;
		ListNode next;
		ListNode (int x) {
			this.val = x;
		}
	}
}
