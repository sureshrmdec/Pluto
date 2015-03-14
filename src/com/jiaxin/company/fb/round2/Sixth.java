package com.jiaxin.company.fb.round2;

import java.util.ArrayList; 
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

import org.junit.Test;


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
	// 1. Overlap - sort and compare - nlogn
	public boolean findOverlap(List<Interval> meetings) {
		if (meetings == null || meetings.size() == 0) {
			return true;
		}
		
		Collections.sort(meetings, meetingComparator);
		
		Interval last = meetings.get(0);
		for (int i = 1; i < meetings.size(); i++) {
			Interval current = meetings.get(i);
			
			if (last.end > current.start) {
				return false; 
			}
			
			last = current;
		}
		
		return true;
	}
	
	public Comparator<Interval> meetingComparator = new Comparator<Interval>() {
		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}
	};
	
	// 2. Maximum Meeting room
	public int maximumMeetingRoom(List<Interval> meetings) {
		if (meetings == null || meetings.size() == 0) {
			return 0;
		}
		
		Collections.sort(meetings, meetingComparator);
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		int room = 1; 
		
		heap.add(meetings.get(0).end); 
		
		for (int i = 1; i < meetings.size(); i++) {
			Interval current = meetings.get(i);
			
			if (heap.peek() <= current.start) {
				heap.poll();
			}
			
			heap.offer(current.end);
		}
		
		return heap.size();
	}

	
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
		
		// 
		// /d1/d2
		Stack<String> stack = new Stack<String>();
		String[] paths = path.split("/");
		for (String dir : paths) {
			if ("..".equals(dir)) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (!".".equals(dir) && !"".equals(dir)) {
				stack.push(dir);
			}
		}
		
		String result = "";
		while (!stack.isEmpty()) {
			result = "/" + stack.pop() + result;
		}
		
		return result.contains(":") ? result.substring(1) : result;
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

	
	// 5. Football see special topic 
	@Test
	public void test() {
		String path1 = "C:/d1/d2/.././d3";
		String path2 = "/d1/../d2/";
		
		System.out.println(simplifyPath(path1));
		System.out.println(simplifyPath(path2));
	}
	
	
	 class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
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
		TreeNode parent;
		TreeNode(int x) { val = x; }
	}
}
