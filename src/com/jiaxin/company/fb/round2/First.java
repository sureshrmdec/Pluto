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
 * 6. Inplace_merge (Ninja)
 * 7. Simple regex (Jedi)
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
