package com.jiaxin.company.ebay;

import java.util.ArrayList;
import java.util.Stack;

/**
 * [面试经验] [已经从了] eBay Intern + 面经 感觉还是有点不安..
 * Interview Time : 2014.4-6
 * Link: http://www.1point3acres.com/bbs/thread-80914-1-1.html
 * 
 * Phone Interview:
 * 1. 给一台内存很小（如10MB），外存无限大的机器，把一个很大的数组（如10GB）排序 -- External Sort
 * 2. Plus One
 * 3. Binary Tree Inorder Traversal
 * 4. Reverse LinkedList
 * --------------------------------------------------------------------------------
 * 
 * [面试经验] eBay 电面经验分享
 * Interview Time:  2013 4-6
 * Link: http://www.1point3acres.com/bbs/thread-69160-1-1.html 
 * 
 * Phone Interview:
 * 1. given a node in a linked list, delete this node without given any other node including head
 * 2. how to merge two sorted linked list
 * 3. 如何测试ebay 交易网
 * 
 * @author jeffwan
 * @date Apr 21, 2014
 */
public class Part12 {	
	// Phone Interview 1
	/* Split into 10Mb for every file. and than use merge sort. once load in part of two files, for example
	 * f1 = 10mb, f2 = 10mb. When merging, only load 5mb of f1, 5mb of f2, output buffer will be 5mb. 
	 * when buffer is full, output the new file, f3. and then load in from the file put into the buffer, f1 or f2.   
	 * Step by Step, all files will be mergesd.
	 */
	
	// Phone Interview 2: Plus One -- 别用System.arraycopy 现场写容易出错
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return digits;
		}
		
		int carry = 1;
		for (int i = digits.length - 1; i >= 0 && carry > 0; i--) {
			int sum = digits[i] + carry;
			digits[i] = sum % 10;
			carry = sum / 10;
		}
		
		if (carry == 0) {
			return digits;
		}
		
		int[] result = new int[digits.length + 1];
		result[0] = carry;
		for (int i = 1; i < result.length; i++) {
			result[i] = digits[i - 1];
		}
		
		return result;
	}
	
	// Phone Interview 3: Inorder Traversal
	public ArrayList<Integer> inorder(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (root != null && !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			if (!stack.isEmpty()) {
				TreeNode current = stack.pop();
				result.add(current.val);
				root = root.right;
			}
		}
		
		return result;		
	}
	
	// Phone Interview 4: Reverse LinkedList - 先存temp, 断开指向prev，prev,head 分别向前. 灰常esay，决不能出错
	public ListNode reverseLinkedList(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode newHead = null;
		while (head != null) {
			ListNode temp  = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;
		}
		
		return newHead; 
	}
	
	/********************************************************/
	// Phone Interview 1: Given a node in a linked list, delete this node without given any other node including head
	//  4 -> 5 -> 6  ----  4-> 6 -> 6  skip掉下一个，这样相当于删除, 这样不用prev来删除了
	public boolean deleteSelf(ListNode node) {
		if (node == null || node.next == null) {
			return false;
		}
		
		node.val = node.next.val;
		node.next = node.next.next;
		return true;
	}
	
	//Phone Interview 2: Merge two sorted linked list
	public ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				head.next = l1;
				l1 = l1.next;
			} else {
				head.next = l2;
				l2 = l2.next;
			}
			
			head = head.next;
		}
		
		if (l1 != null) {
			head.next = l1;
		}
		
		if (l2 != null) {
			head.next = l2;
		}
		
		return dummy.next;
	}
	
	//Phone Interview 3: 如何测试ebay交易网
	/*
	 * 这类产品类测试怎么做?
	 * Concurrency? 压力测试?  Integration Test with other system? 
	 * 
	 */
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
