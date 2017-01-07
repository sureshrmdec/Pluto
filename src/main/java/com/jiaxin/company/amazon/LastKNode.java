package com.jiaxin.company.amazon;

public class LastKNode {
	
	// Two pointer. just need one pass, in-place solution
	public ListNode lastKNode(ListNode head, int k) {
		ListNode runner = head;
		for (int i = 0; i < k; i++) {
			runner = runner.next;
		}
		
		while (runner != null) {
			runner = runner.next;
			head = head.next;
		}
		
		return head;
	}
	
	// LeetCode -- RemoveNthNode
	public ListNode removeNthNode(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode p1 = dummy;
		ListNode p2 = dummy;
		
		for (int i = 0; i < n; i++) {
			p1 = p1.next;
		}
		
		while (p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		p2.next = p2.next.next;
		return dummy.next;
	}
	
	
	class ListNode {
		int val;
		ListNode next;
		ListNode (int x) { this.val = x; }
	}
}
