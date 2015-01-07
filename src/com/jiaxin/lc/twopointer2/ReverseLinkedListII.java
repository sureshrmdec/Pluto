package com.jiaxin.lc.twopointer2;


public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		
		for (int i = 1; i < m; i++) {
			head = head.next;
		}
		
		ListNode prevmNode = head;
		ListNode mNode = head.next;
		ListNode nNode = mNode;
		ListNode postnNode = mNode.next;
		
		for (int i = m; i < n; i++) {
			if (postnNode == null) {
				return null;
			}
			
			ListNode temp = postnNode.next;
			postnNode.next = nNode;
			nNode = postnNode;
			postnNode = temp;
		}
		
		prevmNode.next = nNode;
		mNode.next = postnNode;
		
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
