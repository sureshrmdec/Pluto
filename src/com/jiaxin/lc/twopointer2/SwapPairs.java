package com.jiaxin.lc.twopointer2;


public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode lastNode = dummy;
		
		while (head != null && head.next != null) {
			// swap 
			ListNode temp = head.next.next;
			head.next.next = lastNode.next;
			lastNode.next = head.next;
			head.next = temp;
			
			// move
			lastNode = head;
			head = head.next;
		}
			
		return dummy.next;
    }
	
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
