package com.jiaxin.company.fb.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;


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
 * 4. Max Rectangle Area Underneath Histogram (Jedi)
 * 5. Find the kth Largest element in 2 sorted array of integers (Ninja)
 * 
 * 
 */
public class Third {

	
	// 1. Array union, intersection, 
	/**
	 *  1. General way -- think them as sorted array, two pointer - find common. O(nlogn) + O(n)
	 *  2. HashSet. add all element in A, and then check go through B, if HashSet contains, print
	 * @return
	 */
	public List<Integer> findCommon(int[] A, int[] B) {
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
				j++;
			}
		}
		
		return result;
	}
	/**
	 * 1. Just use Hashset  O(n) + O(n)
	 * 2. Sorted, sames as common, add smaller one and any of equals one. O(nlogn) + O(n) 
	 * 
	 * @return
	 */
	public List<Integer> findUnion(int[] A, int[] B) {
		Set<Integer> union = new HashSet<Integer>();
		for (int number : A) {
			union.add(number);
		}
		
		for (int number : B) {
			union.add(number);
		}
		
		return new ArrayList<Integer>(union);
	}
	
	public List<Integer> findUnionSort(int[] A, int[] B) {
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
				result.add(A[i]);
				i++;
			} else if (A[i] > B[j]) {
				result.add(B[j]);
				j++;
			} else {
				result.add(A[i]);
				i++;
				j++;
			}
		}
		
		return result;
	}
	
	/**
	 *  Diff = Union - Common
	 *  1. Hashset. add all elements of A, and then check B's. print not 
	 * @return
	 */
	
	public List<Integer> findDiff(int[] A, int[] B) {
		
		
		return null;
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
    public String countAndSay(int n) {
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
    
    
    // 4. Max Rectangle Area Underneath Histogram (Jedi)
    // http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
    public int largestRectangleArea(int[] height) {
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
    public static int findKthElement(int[] A, int[] B, int k) {    	
    		return findKth(A, 0, B, 0, k);
    }
    
	private static int findKth(int[] A, int AStart, int[] B, int BStart, int k) {
		if (AStart >= A.length) {
			return B[BStart + k - 1];
		} 
		
		if (BStart >= B.length) {
			return A[AStart + k - 1];
		}
		
		if (k == 1) {
			return Math.min(A[AStart], B[BStart]);
		}
		
		int AKey = AStart + k/2 - 1 < A.length ? A[AStart + k/2 - 1] : Integer.MAX_VALUE;
		int BKey = BStart + k/2 - 1 < B.length ? B[BStart + k/2 - 1] : Integer.MAX_VALUE;
		
		if (AKey < BKey) {
			return findKth(A, AStart + k/2, B, BStart, k - k/2);
		} else {
			return findKth(A, AStart, B, BStart + k/2, k - k/2);
		}
	}

	@Test
	public void test() {
		int[] A1 = {1,3,4,5,7};
		int[] B1 = {2,3,5,6};
		
		System.out.println(findCommon(A1, B1));
		System.out.println(findCommon(A1, B1));
		
		int[] height = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(height));
		
		int[] A = {1,2,3};
		int[] B = {4,5,6,7,8,9,10};
		
		System.out.println(findKthElement(A, B, 4));
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
