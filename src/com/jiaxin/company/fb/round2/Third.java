package com.jiaxin.company.fb.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


/*
 * Phone: 
 * 1. Given two arrays of integers, A and B, find out how many different integers are in both A and B?
 * 2. Given a space ship starting at (X0, Y0), knowing that the shaceship can only do S(X,Y) - (X,Y+1), (X-1,Y+1),
(X+1, Y+1), and that you are in a limited space (W,H), give the maximum score that you get (you get the
bonus of the case you are on).
 * 
 * Onsite: 
 * 1. Inorder binary tree iterator (Ninja)
 * 2. Look and say (Ninja)
 * 3. Proximity Search (Pirate)
 * 4. Max Rectabgke Area Underneath Histogram (Jedi)
 * 5. Find the kth Largest element in 2 sorted array of integers (Ninja)
 * 6.
 * 
 * 
 */
public class Third {

	
	// 1. Given two arrays of integers, A and B, find out how many different integers are in both A and B? -- array union, intersection, 
	// MyWay is counting..
	public static List<Integer> findDiffInteger(int[] A, int[] B) {
		List<Integer> result = new ArrayList<>(A.length);
		boolean[] Aarray = new boolean[A.length];
		boolean[] Barray = new boolean[B.length];
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (A[i] == B[j]) {
					Aarray[i] = true;
					Barray[j] = true;
				}
			}
		}
		
		for (int i = 0; i < A.length; i++) {
			if (Aarray[i] == false) {
				result.add(A[i]);
			}
		}

		for (int i = 0; i < B.length; i++) {
			if (Barray[i] == false) {
				result.add(B[i]);
			}
		}
		
		return result;
	}
	
	// General way -- think them as sorted array, two pointer - find common. O(m*n) Diff, just need another round iterator
	public static List<Integer> findCommon(int[] A, int[] B) {
		List<Integer> result = new ArrayList<Integer>();
		if (A == null || B == null || A.length == 0 || B.length == 0) {
			return result;
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int i = 0;
		int j = 0;
		
		while (i < A.length && j < B.length) {
			if (A[i] < B[j]) {
				i++;
			} else if (A[i] > B[j]) {
				j++;
			} else {
				result.add(A[i]);
				i++;
			}
		}
		
		return result;
	}
	
	// 2. Given a space ship starting at (X0, Y0), knowing that the shaceship can only do S(X,Y) - (X,Y+1), (X-1,Y+1),
	// (X+1, Y+1), and that you are in a limited space (W,H), give the maximum score that you get (you get the
	// bonus of the case you are on).
	
	
	// 1. Inorder binary tree Iterator
	public class BSTIterator {
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode current;
	    
	    public BSTIterator(TreeNode root) {
	         this.current = root;
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	    	return (current != null || !stack.isEmpty());
	    }

	    /** @return the next smallest number */
	    public int next() {
	    	while (current != null) {
	    		stack.push(current);
	    		current = current.left;
	    	}
	    	
	    	current = stack.pop();
	    	TreeNode node = current;
	    	current = current.right;
	    	
	    	return node.val;
	    }
	}
	
	
	
	// 2. Look and say (Ninja)
    public static String countAndSay(int n) {
    	String oldString = "1";
    	
    	while (--n > 0) {
    		StringBuilder sb = new StringBuilder();
    		
    		for (int i = 0; i < oldString.length(); i++) {
    			int count = 1;
    			
    			while (i + 1 < oldString.length() && oldString.charAt(i) == oldString.charAt(i + 1)) {
    				i++;
    				count++;
    			}
    			
    			sb.append(String.valueOf(count) + String.valueOf(oldString.charAt(i)));
    		}
    		
    		oldString = sb.toString();
    	}

    	return oldString;
    }
	
	
	// 3. Proximity Search (Pirate) -- do Pirate together
    
    
    // 4. Max Rectabgke Area Underneath Histogram (Jedi)
    public static int largestRectangleArea(int[] height) {
    	if (height == null || height.length == 0) {
    		return 0;
    	}
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	int max = 0;
    	
    	for (int i = 0; i <= height.length; i++) {
    		int current = (i == height.length) ? -1 : height[i];
    		
    		while (!stack.isEmpty() && current < height[stack.peek()]) {
    			int h = height[stack.pop()];
    			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
    			max = Math.max(max, h * w);
    		}
    		
    		stack.push(i);
    	}
    	
    	return max;
    }
    
    
    // 5. Find the kth Largest element in 2 sorted array of integers (Ninja)  -- median of two sorted array
    
    
    
    
    
    
	public static void main(String[] args) {
		int[] height = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(height));
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
