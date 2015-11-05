package com.diorsding.advance.twopointer;

/**
 * http://www.lintcode.com/en/problem/linked-list-cycle/
 * http://www.lintcode.com/en/problem/linked-list-cycle-ii/
 * 
 * Follow up: Can you solve it without using extra space?  For Both I, II 
 * 
 * 
 * @author jiashan
 *
 */
public class LinkedListCycle {

	
	public boolean hasCycle(ListNode head) {		
		ListNode slow = head;
		ListNode fast = head;
		
		do {
			if (fast == null || fast.next == null) {
				return false;
			}
			
			slow = slow.next;
			fast = fast.next.next;
			
		} while (slow != fast);
		
		return true;
    }
	
	//  Time out... Fast should be head? seems. head.next doesn't work 
	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode slow = head;
		ListNode fast = head.next;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			// move slow to head
			if (slow == fast) {
				slow = head; 
				
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				
				return slow;
			}
		}
		
		return null;  
    }
	
	public ListNode detectCycleAlternative(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		do {
			if (fast == null || fast.next == null) {
				return null;
			}
			
			slow = slow.next;
			fast = fast.next.next;
			
		} while (slow != fast);
		
		slow = head; 
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
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
