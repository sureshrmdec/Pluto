package com.jiaxin.company.fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


/*
 * Phone:
 * 1. Given a set of binary tree nodes, return null if the nodes do not form a valid binary tree and 
 * otherwise return the overall root of the tree. 
 * 
 * Onsite:
 * 1. Binary search in a rotated array (Ninja)
 * 2. Design a sparse matrix implementation (Pirate)
 * 3. Square a matrix with side length = 10^10 and density = 10^-9 in less than a day (Pirate)
 * 4. Print tree by levels (Ninja)
 * 5. Dedupe string (Ninja)
 * 6. Sqrt (Ninja)
 * 7. Given a word like fireman, find the number of partitions that are english words, such that the number of partitions is
maximal. Every letter must be assigned to a partition. For example, fireman can be split into
  		|fir|em|an|    |fire|man|     |fireman|
Since three is the most partitions that work, the answer is 3. Assume you have a hashset data structure containing every
english word. Return zero if there is no valid partitioning. (Jedi)
 *
 */


public class Thirteen {
	/**********************************************************************************************************/
	// 1. Don't understand this quesiton -> convert to  isValidBST
	TreeNode lastNode = null;
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		if (!isValidBST(root.left)) {
			return false;
		}
		
		if (lastNode != null && lastNode.val >= root.val) {
			return false;
		}
		
		lastNode = root;
		
		if (!isValidBST(root.right)) {
			return false;
		}
		
		return true;
	}
	
	
	
	/**********************************************************************************************************/
	// 1. Binary search in a ratated array	
	public int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}
		
		int start = 0;
		int end = A.length - 1;
	
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			
			if (target == A[mid]) {
				return mid;
			}
			
			if (A[start] < A[mid]) {
				if (target >= A[start] && target < A[mid]) {
					end = mid;
				} else {
					start = mid;
				}
			} else if (A[start] > A[mid]) {
				if (target > A[mid] && target <= A[end]) {
					start = mid;
				} else {
					end = mid;
				}
			} else {
				start++;
			}
		}
		
		if (target == A[start]) {
			return start;
		}
		
		if (target == A[end]) {
			return end;
		}
		
		return -1;
	}
	
	
	/**********************************************************************************************************/
	// 4. Print tree by levels (Ninja)
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		if (root == null) {
			return result;
		}
		
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
	
	
	
	/**********************************************************************************************************/
	// 5. Dedupe string (Ninja) For dedupe str, he knew he would need a lookup structure, and had good questions on constraints on the characters (ascii, unicode, etc.) Coded quickly well.
	
	
	
	
	
	/**********************************************************************************************************/
	// 6. Sqrt (Ninja)
	public int sqrt(int x) {
		if (x < 0) {
			throw new IllegalArgumentException("x can't be negative");
		}
		
		if (x == 0) {
			return 0;
		}
		
		int start = 1;
		int end = x / 2 + 1;
		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			
			if (x / mid == mid) {
				return mid;
			} else if (x / mid < mid) {
				end = mid;
			} else {
				start = mid;
			}
		}
		
		if (x / start == start) {
			return start;
		} 
		
		if (x / end == end) {
			return end;
		}
		
		return start;
	}
	
	
	/**********************************************************************************************************/
	// 7. Word break II - ask all solutions.
	public static List<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> result = new ArrayList<String>();
		if (s == null || s.length() == 0)
			return result;
		helper(s, dict, 0, "", result);
		return result;
    }

	private static void helper(String s, Set<String> dict, int start,
			String item, List<String> res) {
		if (start >= s.length()) {
			res.add(item);
			return;
		}
		StringBuilder str = new StringBuilder();
		for (int i = start; i < s.length(); i++) {
			str.append(s.charAt(i));
			if (dict.contains(str.toString())) {
				String newItem = item.length() > 0 ? (item + " " + str
						.toString()) : str.toString();
				helper(s, dict, i + 1, newItem, res);
			}
		}
	}



	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		String s = "catsanddog";
		
		Set<String> dicts = new HashSet<>();
		dicts.add("a");
		String ss = "a";
		
		System.out.println(wordBreak(s, dict));
	}


	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
