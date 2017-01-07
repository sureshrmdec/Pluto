package com.jiaxin.lc.twopointer2;


public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
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
    
    public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
