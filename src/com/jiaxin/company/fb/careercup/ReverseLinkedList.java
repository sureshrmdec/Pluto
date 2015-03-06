package com.jiaxin.company.fb.careercup;

import org.junit.Test;

/**
 * Write a program that reverses a linked list without using more than O(1) storage.
 * 
 * @author jiashan
 *
 */
public class ReverseLinkedList {
	public ListNode reverseLinkedList(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode newHead = null;
		
		while (head != null) {
			ListNode temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp; 
		}
		
		return head;
	}
	
	@Test
	public void test() {
		
	}
	
	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
