package com.jiaxin.company.fb.careercup;

import java.util.Stack;

import org.junit.Test;

/**
 * Write a program that reverses a linked list without using more than O(1) storage.
 * 
 * 1. Reverse and print -- change structure
 * 2. Stack to store and print 
 * 3. recursive way
 * 
 * 
 * @author jiashan
 *
 */
public class ReverseLinkedList {
	// 1. reverse list
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
		
		while (newHead != null) {
			System.out.print(newHead.val + " -> ");;
			newHead = newHead.next;
		}
		
		return newHead;
	}
	
	// 2. use stack. 
	public void reversePrintList(ListNode head) {
		Stack<ListNode> stack = new Stack<ListNode>();
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().val + " -> ");
		}
	}
	
	// 3. recursive call 
	public void reversePrintListRecursive(ListNode head) {
		if (head == null) {
			return;
		}
		
		reversePrintListRecursive(head.next);
		
		System.out.print(head.val + " -> ");
	}
	
	
	@Test
	public void test() {
		System.out.println();
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		
		reverseLinkedList(node);
	}
	
	@Test
	public void test1() {
		System.out.println();
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		
		reversePrintList(node);
	}
	
	@Test
	public void test2() {
		System.out.println();
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		
		reversePrintListRecursive(node);
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
