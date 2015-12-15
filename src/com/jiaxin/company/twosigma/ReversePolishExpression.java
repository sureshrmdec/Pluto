package com.jiaxin.company.twosigma;

import java.util.ArrayList;
import java.util.Stack;

public class ReversePolishExpression {

	// Reverse Polish Expression
	
	public ArrayList<String> convertToPN(String[] expression) {
		ArrayList<String> result = new ArrayList<String>();
		if (expression == null || expression.length == 0) {
			return result;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int base = 0;
		int val = 0;
		
		for (int i = 0; i <= expression.length; i++) {
			if (i != expression.length) {
				if ("(".equals(expression[i])) {
					base += 10;
					continue;
				}
				
				if (")".equals(expression[i])) {
					base -= 10;
					continue;
				}
				
				val = getPriority(expression[i], base);
			}
			
			TreeNode right = i == expression.length ? new TreeNode(Integer.MIN_VALUE, "") : new TreeNode(val, expression[i]);
			
			while (stack.isEmpty()) {
				if (right.val <= stack.peek().val) {
					TreeNode node = stack.pop();
					
					if (stack.isEmpty()) {
						right.left = node;
					} else {
						TreeNode left = stack.peek();
						
						if (left.val > right.val) {
							left.right = node;
						} else {
							right.left = node;
						}
					}
				} else {
					break;
				}
			}
			
			stack.push(right);
		}
		
		ArrayList<String> polish = new ArrayList<String>();
		traversal(stack.peek().left, polish);
		
		return null;
	}
	
	private void traversal(TreeNode root, ArrayList<String> list) {
		if (root == null) {
			return;
		}
		
		list.add(root.s);
		
		if (root.left != null) {
			traversal(root.left, list);
		}
		
		if (root.right != null) {
			traversal(root.right, list);
		}
	}

	private int getPriority(String a, Integer base) {
		if ("+-".contains(a)) {
			return 1 + base;
		}
			
		if ("*/".contains(a)) {
			return 2 + base;
		}

		return Integer.MAX_VALUE;
	}

	class TreeNode {
		int val;
		String s;
		TreeNode left;
		TreeNode right;
		
		public TreeNode() {}
		
		public TreeNode(int val, String s) {
			this.val = val;
			this.s = s;
			this.left = this.right = null;
		}
	}
}
