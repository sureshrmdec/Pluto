package com.jiaxin.company.fb.round2;

import java.util.ArrayList;
import java.util.List;


/*
 * Andorid, skip most 
 * Phone:
 * 1. Max Number of meetings to attend from a list of meetings -- find largest single intervals 
 * 2. Remove zeros from array -- same as sort colors
 * 
 * onsite
 * 
 * 1. Binary tree to linked list (Ninja)  -- Any non-recursive way to do this?
 * 2. Roman Numerals into Integers (Ninja)
 * 3. Design an HTTP downloader. Be explicit about classes, their functions, data structures and method signatures. (Pirate)
 * 4. Reverse a linked list (Jedi) 
 */
public class Fifth {
	// 1. Max number of meetings to attend from a list of meetings
	// 2. You have a number of meetings (with their start and end times). You need to schedule them using the minimum number of rooms. Return the list of meetings in every room. 
	public int maxMeetings(List<Interval> intervals) {
		
		
		return 0;
	}
	
	
	// 2. remove zeros from array [1, 0, 2, 4, 0, 3] -> [1, 4, 3, 2, ?, ?]. return nonZero numbers
	// Test case: zeroIndex--, points to 0, so must be i <= zeroIndex
	public static int removeZeros(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		int zeroIndex = A.length - 1;
		int i = 0;
		
		while (i <= zeroIndex) {
			if (A[i] == 0) {
				int temp = A[i];
				A[i] = A[zeroIndex];
				A[zeroIndex] = temp;
				zeroIndex--;
			} else {
				i++;
			}
		}
		
		return zeroIndex + 1;
	}
	
	
	

	// 1. Flattern Binary Tree to Linked List
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
	
	// 2. Roman Numbers to integers 
	public int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		int result = charToInt(s.charAt(s.charAt(0)));
		
		for (int i = 1; i < s.length(); i++) {
			int last = charToInt(s.charAt(i - 1));
			int current = charToInt(s.charAt(i));
			
			if (last < current) {
				result += current - 2 * last;
			} else {
				result += current;
			}
		}
		
		return result;
	}

	public int charToInt(char c) {
		return 0; // During the interview, talk to interviewer about this and save some time. 
	}
	
	// 3. Design an HTTP downloader. Be explicit about classes, their functions, data structures and method signatures. (Pirate)
	
	
	// 4. Reverse Linked List
	public static ListNode reverseLinkedList(ListNode head) {
		ListNode newHead = null;
		
		while (head != null) {
			ListNode temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;
		}
		
		return newHead;
	}
	
	
	
	public static void main(String[] args) {
		int[] A = {1, 0, 2, 4, 0, 3} ;
		
		removeZeros(A);
		List<Integer> list = new ArrayList<Integer>();
		for (Integer x : A) {
			list.add(x);
		}
		
		System.out.println(list);
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node1.next = node2; node2.next = node3;
		
		ListNode head = reverseLinkedList(node1);
		
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	
	 class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
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
