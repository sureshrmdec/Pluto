package com.jiaxin.company.fb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
 * 1. Design a distributed message but with high reliability, as well as high write availability, 
 * trading for lower read availability. (Pirate)
 * 2. Populate nearest distance to guards in a 2D maze. (Ninja) 
 * 3. Print tree by level (Jedi)
 * 4. return the most common letter in a string (Ninja)
 * 
 */
public class Seventh {

	// 3. Print tree by level (Jedi)
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<Integer>();
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				root = queue.poll();
				list.add(root.val);
				
				if (root.left != null) {
					queue.offer(root.left);
				}
				
				if (root.right != null) {
					queue.offer(root.right);
				}
			}
					
			result.add(list);
		}
		
		return result;
	}
	
	
	// 4. return the most common letter in a string (Ninja)
	public char mostCommonLetter(String s) {
		
		
		return 0;
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
