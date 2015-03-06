package com.jiaxin.company.fb.round1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/*
 * 1. Design a distributed message but with high reliability
 * 2. Follow up: As well as high write availability, trading for lower read availability. (Pirate)
 * 3. Populate nearest distance to guards in a 2D maze. (Ninja) 
 * 4. Print tree by level (Jedi)
 * 5. return the most common letter in a string (Ninja)
 * 
 */
public class Seventh {
	// 3. Given a 2D maze with guards in it, populate another 2D array with the distance to the nearest guard,
	// or -1 if unreachable from a guard. 
	public int[][] nearestguard(int[][] matrix) {
		
		
		
		return matrix;
	}
	
	
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
	
	
	// 5. return the most common letter in a string (Ninja)
	public char mostCommonLetter(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char result = '0';
		
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			
			if (!map.containsKey(temp)) {
				map.put(temp, 1);
			} else {
				map.put(temp, map.get(temp) + 1);
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (Map.Entry<Character, Integer> entry: map.entrySet()) {
			if (entry.getValue() > max) {
				result = entry.getKey();
				max = entry.getValue();
			}
		}
		
		return result;
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
