package com.jiaxin.company.fb.round2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Phone:
 * Seems no phone screen
 * 
 * Onsite: 
 * 1. Print Tree By Levels (Ninja) 
 * 2. Pick a random element from linkedlist (Ninja)
 * 3. Roman to Integer (Ninja)
 * 4. Live likes/moments for the android app (Pirate)
 * 5. Look and say (Ninja)
 * 6. Inplace_merge (Ninja)  -- work on it.
 * 7. Simple regex (Jedi) -- not sure the quesiton.
 *  
 */
public class First {

	// 1. Print Tree By Levels 
	public List<List<Integer>> levelOrders(TreeNode root) {
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
	
	// 2. Pick a random element from linkedlist (Ninja)
	public ListNode randomSelect(ListNode head) {
		
		
		
		return null;
	}
	
	// 3. Roman to Integer
	public int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		int result = charToInt(s.charAt(0));
		
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
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
    }
	
	// 5. Look and say
	public String countAndSay(int n) {
		String oldString = "1";
		
		while (--n > 0) {
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < oldString.length(); i++) {
				int count = 1;
				
				while (i + 1  < oldString.length() && oldString.charAt(i) == oldString.charAt(i + 1)) {
					i++;
					count++;
				}
				
				sb.append(String.valueOf(count) + String.valueOf(oldString.charAt(i)));
			}
			
			oldString = sb.toString();
		}
		
		return oldString;
	}
	
	// 6. Inplace_merge (Ninja)  -- work on it.
	
	
	
	
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
