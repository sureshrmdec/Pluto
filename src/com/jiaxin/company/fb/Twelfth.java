package com.jiaxin.company.fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


/*
 * Phone: 
 * 1. You are given a string with no space and a set of valid words. Segment the string such that all the segments 
 * are contained in the set of valid words.
 * 2. Look and say
 * 3. connected components problem - metapage clustering 
 * 
 * Onsite:
 * 1. Print tree by levels (Ninja)
 * 2. Enumerate substrings of a string which are palindromes (Ninja) -- get all substring first?
 * 3. Max Intervals (Jedi)
 * 4. Graph clone (Jedi)
 * 5. Build a language classifier given sentences from two languages (Pirate)
 * 6. Design status update search (Pirate)
 * 
 */
public class Twelfth {
	// 1. Word break --> segment the string and make all words valid in dict \
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
			return false;
		}
		
		int maxLength = getMaxLength(dict);
		
		boolean[] canSegment = new boolean[s.length() + 1];
		canSegment[0] = true;
		
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j < maxLength && j <= i; j++) {
				String word = s.substring(i - j, i);
				if (canSegment[i - j] && dict.contains(word)) {
					canSegment[i] = true;
				}
			}
		}
		
		return canSegment[s.length()];
    }
	
	
	private int getMaxLength(Set<String> dict) {
		int length = 0;
		
		for (String s : dict) {
			length = Math.max(length, s.length());
		}
		
		return length;
	}
	
	// word break II -> ask all break word combinations

	/***********************************************************************************************************/
	// 2. Count and say? Look and say?  If them ask all result, List<String> result = new ArrayList<String>(n); as n--, we need record n first. return result.get(result.size() - 1)
	// follow up: what's the largest number to be seen in the sequence. -- 3. can't be 4.
	public static String countAndSay(int n) {
		String oldString = "1";
		
		while (--n > 0) {
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < oldString.length(); i++) {
				int count = 1;
				while (i + 1 < oldString.length() && oldString.charAt(i) == oldString.charAt(i + 1)) {
					count++;
					i++;
				}
				
				sb.append(String.valueOf(count) + oldString.charAt(i));
			}
			
			oldString = sb.toString();
		}
		
		return oldString;
	}
	
	/***********************************************************************************************************/
	// 3. Connected components
	
	


	/***********************************************************************************************************/
	// 1. print tree by level 	
	// also could use two queues -- curLevel, nextLevel -- stupid.. remember to use queue.isEmpty but not queue.size(). queue size is changing!
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<Integer>();
			
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
	
	/***********************************************************************************************************/
	// 2. Enumerate substrings of a string which are palindromes (Ninja)
	// a simple iterative solution which is O(n) best-case and O(n^2) worst-case, whereas dynamic programming is always O(n^2). A
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();
		
		if (s == null || s.length() == 0) {
			return result;
		}
		
		helper(result, list, s, 0);
		
		return result;
	}


	private void helper(List<List<String>> result, List<String> list, String s, int position) {
		if (position == s.length()) {
			result.add(new ArrayList<String>(list));
			return;
		}
		
		for (int i = position; i < s.length(); i++) {
			String prefix = s.substring(position, i + 1);
			if (!isPalindrome(prefix)) {
				continue;
			}
			
			list.add(prefix);
			helper(result, list, s, i + 1);
			list.remove(list.size() - 1);
		}
	}


	private boolean isPalindrome(String prefix) {
		int left = 0;
		int right = prefix.length() - 1;
		
		while (left < right) {
			if (prefix.charAt(left) != prefix.charAt(right)) {
				return false;
			}
			
			left++;
			right--;
		}
		
		return true;
	}

	
	/***********************************************************************************************************/
	// 3. Max Intervals (Jedi) find the interval overlap others more? [0,5] [2,9] [8,10] [6,9] -> [8,10] 
	// visiting the endpoints in order and counting the nesting level 
	// [0,5 ] [2,10] [6,9] [8,11]
	//http://www.careercup.com/question?id=15465824
	//http://codeanalysis111.blogspot.com/2014/11/facebook-interval-problem.html
	
	
	
	
	/***********************************************************************************************************/
	// 4. Graph clone  -- Use HashMap to store relationship between node and new copy
	// BFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if (node == null) {
    		return null;
    	}
    	
    	Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    	Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    	UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
    	map.put(node, copy);
    	queue.offer(node);
    	
    	while (!queue.isEmpty()) {
    		UndirectedGraphNode current = queue.poll();
    		
    		for (int i = 0; i < current.neighbors.size(); i++) {
    			if (!map.containsKey(current.neighbors.get(i))) {
    				copy = new UndirectedGraphNode(current.neighbors.get(i).label);
    				map.put(current.neighbors.get(i), copy);
    				queue.offer(current.neighbors.get(i));
    			}
    			
    			map.get(current).neighbors.add(map.get(current.neighbors.get(i)));
    		}
    	}
    	
    	return map.get(node);
    }
    
    // DFS
    public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
    	if (node == null) {
    		return null;
    	}
    	
    	Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    	UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
    	map.put(node, copy);
    	helperCloneDFS(node, map);
    	
    	return copy;
	}


	private void helperCloneDFS(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
		for (int i = 0; i < node.neighbors.size(); i++) {
			UndirectedGraphNode current = node.neighbors.get(i);
			
			if (!map.containsKey(current)) {
				UndirectedGraphNode copy = new UndirectedGraphNode(current.label);
				map.put(current, copy);
				helperCloneDFS(current, map);
			}
			
			map.get(node).neighbors.add(map.get(current));
		}
		
	}


	public static void main(String[] args) {
		System.out.println(countAndSay(6));
	}
	
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};
	
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
