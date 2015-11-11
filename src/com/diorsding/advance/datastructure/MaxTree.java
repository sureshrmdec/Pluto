package com.diorsding.advance.datastructure;

import java.util.Stack;

import org.junit.Test;

/**
 * http://www.lintcode.com/en/problem/max-tree/
 * Challenge: O(n) time & memory.
 * 
 * Up -> down. 
 * 1. find max. left -> left tree, right -> right tree. Recursive
 * [1,2,3,4,5,6,7] worst case O(n^2)
 * 
 * Down -> up, find parent.
 * find first element left or right larger than every number.
 * 
 * @author jiashan
 *
 */
public class MaxTree {

	// Stack Overflow in OJ
	public TreeNode maxTree(int[] A) {
		return buildMaxTree(A, 0, A.length - 1);
    }
	
	private TreeNode buildMaxTree(int[] A, int start, int end) {
		int index = findMax(A, start, end);
		
		TreeNode root = new TreeNode(A[index]);
		
		if (index != start) {
			root.left = buildMaxTree(A, start, index - 1);
		}
		
		if (index != end) {
			root.right = buildMaxTree(A, index + 1, end);
		}
				
		return root;
	}

	private int findMax(int[] A, int start, int end) {
		int max = Integer.MIN_VALUE;
		int index = 0;
		for (int i = start; i <= end; i++) {
			if (A[i] > max) {
				max = A[i];
				index = i;
			}
		}
		return index;
	}

	public TreeNode maxTreeOn(int[] A) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		for (int i = 0; i <= A.length; i++) {
			TreeNode right = i == A.length ? new TreeNode(Integer.MAX_VALUE) : new TreeNode(A[i]);
			
			while (!stack.isEmpty()) {
				if (right.val > stack.peek().val) {
					TreeNode node = stack.pop();
					if (stack.isEmpty()) {
						right.left = node;
					} else {
						TreeNode left = stack.peek();
						if (left.val > right.val) {
							right.left = node;
						} else {
							left.right = node;
						}
					}
				} else {
					break;
				}
			}
			
			stack.push(right);
		}
		
		return stack.peek().left;
    }
	
	@Test
	public void test() {
		int[] A = {2,5,6,0,3,1};
		System.out.println(maxTreeOn(A));
	}



	private class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}
	
}


