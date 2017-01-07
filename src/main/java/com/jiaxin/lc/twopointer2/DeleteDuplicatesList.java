package com.jiaxin.lc.twopointer2;

public class DeleteDuplicatesList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode newHead = head;
		
		while (head.next != null) {
			if (head.next.val == head.val) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}
		
		return newHead;
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
