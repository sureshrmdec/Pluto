package com.jiaxin.company.fb.round1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Phone:
 * 1. Print tree by level
 * 2. Dot Product of sparse vectors
 * 
 * Onsite: 
 * 1. Majority voting (Ninja)
 * 2. Design a news feed API (Pirate)
 * 3. Password Permutation, recursive/ non (Jedi) 
 * 4. Dutch National Flag Problem. (Njnja) http://en.wikipedia.org/wiki/Dutch_national_flag_problem
 * 5. Unique characters in a string. (Njnja) 
 * 
 */
public class First {
	// 1. Print Tree By Level
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if (root == null) {
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<Integer>();
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				root = queue.poll();
				level.add(root.val);
				
				if (root.left != null) {
					queue.offer(root.left);
				}
				
				if (root.right != null) {
					queue.offer(root.right);
				}
			}
			result.add(level);
		}
		
		return result;
	}
	
	/**************************************************************************/
	// 2. Dot Product of sparse vectors， C++ specific? 
	public int dotProdcut(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		
		int product = 0; 
		
		for (int i = 0; i < m; i++) {
			product += A[i] * B[i];
		}
		
		return product;
	}
	
	/**************************************************************************/
	// 1. Majority Voting (Credit card fraud)
	// Given N credit cards and an isSame(A, B) API. determine if there's a strict majority.
	
	/**************************************************************************/
	// 2. Password Permutation  --> Permutation n! , Combination 2^n
	public List<String> pwdPermute(String pwd) {
		List<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		
		if (pwd == null || pwd.length() == 0) {
			return result;
		}
		
		helper(result, sb, pwd);
		
		return result;
	}

	private void helper(List<String> result, StringBuilder sb, String pwd) {
		if (sb.length() == pwd.length()) {
			result.add(sb.toString());
		}
		
		for (int i = 0; i < pwd.length(); i++) {
			String str = sb.toString();
			
			if (str.contains(String.valueOf(pwd.charAt(i)))) {
				continue;
			}
			
			sb.append(str.charAt(i));
			helper(result, sb, pwd);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
	// Iterative way
	

	/**************************************************************************/
	// 3.Dutch National Flag Problem (Sort Colors)  Bubble Sort -> Count Sort -> One Pass Two Pointer
	public void sortColors(int[] A) {
		if (A == null || A.length == 0) {
			return;
		}
		
		int left = 0;
		int right = A.length - 1;
		int i = 0;
		
		while (i <= right) {
			if (A[i] == 0) {
				swap(A, i, left);
				left++;
				i++;
			} else if (A[i] == 2) {
				swap(A, i, right);
				right--;
			} else {
				i++;
			}
		}
	}

	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}



	/**************************************************************************/
	// 5. Unique Characters in a string
	public boolean uniChar(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		
		int[] count = new int[256];
		
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i)]++;
		}
		
		for (int i = 0; i < s.length(); i++) {
			if (--count[s.charAt(i)] > 0) {
				return true;
			}
		}
		
		return false; 
	}
	
	
	
	
	public static void main(String[] args) {
		
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
