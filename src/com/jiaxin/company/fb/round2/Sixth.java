package com.jiaxin.company.fb.round2;

import java.util.ArrayList; 
import java.util.List;
import java.util.Stack;


/*
 * Android 
 * Phone: 
 * 1. Given a list of meetings, each has a start and end time, write a function that returns whether or not any of the meetings overlap
 * 2. A bunch of these meetings might overlap, and we have to schedule them into rooms. Determine the minimum number of rooms we would need.
 * 
 * Onsite:
 * 1. Phone String (Jedi)
 * 2. cd command (Ninja) 
 * 3. Area under skyline (Ninja) -- not same as Histogram
 * 4. Greater value in BST (Ninja)
 * 5. Football scores (Ninja)  - DP way?
 * 6. design a photo uploader (Pirate) 
 * 
 * 
 */
public class Sixth {
	// 1. Overlap - sort and compare - nlgn, just force to do it n2
	// 2. 
	
	
	// 1. Phone String (Jedi) 
	char[][] map = {{}, {}, {'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'}, {'m','n','o'}, 
			{'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};
	
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		
		if (digits == null) {
			return result;
		}
		
		phoneHelper(result, sb, digits);
		
		return result;
	}

	private void phoneHelper(List<String> result, StringBuilder sb, String digits) {
		if (sb.length() == digits.length()) {
			result.add(sb.toString());
			return;
		}
		
		int index = Character.getNumericValue(digits.charAt(sb.length()));
		
		for (int i = 0; i < map[index].length; i++) {
			sb.append(map[index][i]);
			phoneHelper(result, sb, digits);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	// 2. cd command -- Simplify Path -- support absolute path and relative path
	public String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return "";
		}
		
		// C:/d1/d2/.././d3
		// /d1/d2
		Stack<String> stack = new Stack<String>();
		String[] paths = path.split("/");
		for (String dir : paths) {
			if ("..".contains(dir)) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (!".".equals(dir) && !"".equals(dir)) {
				stack.push(dir);
			}
		}
		
		String result = "";
		while (!stack.isEmpty()) {
			result = stack.pop() + result;
		}
		
		return result;
	}
	
	
	// 3. Area under skyline (Ninja)
	// http://www.shadabahmed.com/blog/2013/04/24/skyline-algorithm-a-binary-tree-approach
	//Given a set of rectangular buildings (X-start, X-end, height), calculate the total area of the skyline
	// (avoiding double counting overlapping buildings). 
	
	// 4. Greater value in BST (Ninja)  3 case to consider. 
	public TreeNode greaterValueBST(TreeNode node) {
		if (node == null) {
			return null;
		}
		
		if (node.right != null) {
			node = node.right;
			while (node.left != null) {
				node = node.left;
			}
			
			return node;
		} else {
			while (node.parent != null && node.parent.right == node) {
				node = node.parent;
			}
			
			return node.parent;
		}
	}

	
	// 5. Football
	

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		TreeNode(int x) { val = x; }
	}
}
