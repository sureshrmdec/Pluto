package com.jiaxin.company.fb.round2;

/*
 * Andorid, skip most 
 * 1. Reverse a linked list 
 * 2. Binary tree to linked list
 */
public class Fifth {
	// 1. Reverse Linked List
	public static ListNode reverseLinkedList(ListNode root) {
		ListNode newHead = null;
		
		while (root != null) {
			ListNode temp = root.next;
			root.next = newHead;
			newHead = root;
			root = temp;
		}
		
		return newHead;
	}
	
	// 2. Flattern Binary Tree to Linked List
	TreeNode lastNode;
	public void flattern(TreeNode root) {
		if (root == null) {
			return;
		}
		
		if (lastNode != null) {
			lastNode.left = null;
			lastNode.right = root;
		}
		
		lastNode = root; 
		TreeNode right = root.right;
		flattern(root.left);
		flattern(right);
	}
	
	public static void main(String[] args) {
		double newValue = 0.099;
		if (newValue - 0.1 < 0.001) {
			newValue = 0.1;
		}
		System.out.println(String.format("%.3f", 0.0005));
	}
	
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
