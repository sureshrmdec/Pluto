package com.jiaxin.lc.twopointer3;


public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		int carry = 0;
		
		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + carry;
			carry = sum / 10;
			ListNode node = new ListNode(sum % 10);
			head.next = node;
			head = head.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		
		while (l1 != null) {
			int sum = l1.val + carry;
			carry = sum / 10;
			ListNode node = new ListNode(sum % 10);
			head.next = node;
			head = head.next;
			l1 = l1.next;
		}
		
		while (l2 != null) {
			int sum = l2.val + carry;
			carry = sum / 10;
			ListNode node = new ListNode(sum % 10);
			head.next = node;
			head = head.next;
			l2 = l2.next;
		}
		
		if (carry != 0) {
			head.next = new ListNode(carry);
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
