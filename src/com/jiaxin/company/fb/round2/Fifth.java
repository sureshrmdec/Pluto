package com.jiaxin.company.fb.round2;


/*
 * Andorid, skip most 
 * Phone:
 * 1. Max Number of meetings to attend from a list of meetings
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
	// DP? 
	
	
	// 2. remove zeros from array [1, 0, 2, 4, 0, 3] -> [1, 4, 3, 2, ?, ?]. return nonZero numbers
	// Test case: zeroIndex--, met 0, at last, we need to make it pointer to non-zero element
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
		
		return zeroIndex;
	}
	
	
	

	// 1. Flattern Binary Tree to Linked List
	TreeNode lastNode;
	public void flattern(TreeNode root) {
		if (root == null) {
			return;
		}
		
		if (lastNode != null) {
			lastNode.right = root;
			lastNode.left = null;
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
		return 0; // I don't want to waste time on dup things.
	}
	
	// 3. Design an HTTP downloader. Be explicit about classes, their functions, data structures and method signatures. (Pirate)
	
	
	// 4. Reverse Linked List
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
	
	
	
	public static void main(String[] args) {
		int[] A = {1, 0, 2, 4, 0, 3} ;
		
	}
	
	
	class ListNode {
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
