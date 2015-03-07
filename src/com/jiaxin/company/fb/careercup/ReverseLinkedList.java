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
		
		return newHead;
	}
	
	@Test
	public void test() {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		
		printLinkedList(node);
		ListNode newHead = reverseLinkedList(node);
		
		printLinkedList(newHead);
	}
	
	public void printLinkedList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println();
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
