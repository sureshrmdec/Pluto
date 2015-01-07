package com.jiaxin.lc.twopointer2;


public class DeleteDuplicatesListII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		
		while (head.next != null && head.next.next != null) {
			if (head.next.val == head.next.next.val) {
				int value = head.next.val;
				
				while (head.next != null && head.next.val == value) {
					head.next = head.next.next;
				}
			} else {
				head = head.next;
			}
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



