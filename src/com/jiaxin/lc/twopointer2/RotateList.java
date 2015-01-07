package com.jiaxin.lc.twopointer2;


public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		ListNode tail = dummy;
		
		n = n % getLength(head);
		
		for (int i = 0; i < n; i++) {
			head = head.next;
		}
		
		while (head.next != null) {
			head = head.next;
			tail = tail.next;
		}
		
		head.next = dummy.next;
		dummy.next = tail.next;
		tail.next = null;
		
		return dummy.next;
	}

	
	private int getLength(ListNode head) {
		int length = 0;
		
		while (head != null) {
			length++;
			head = head.next;
		}
		
		return length;
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
