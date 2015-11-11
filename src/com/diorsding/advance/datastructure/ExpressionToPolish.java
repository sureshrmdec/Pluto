package com.diorsding.advance.datastructure;

import java.util.ArrayList;
import java.util.Stack;


/**
 * http://www.lintcode.com/en/problem/convert-expression-to-polish-notation/
 * 
 * For the expression [(5 − 6) * 7] (which represented by ["(", "5", "−", "6", ")", "*", "7"]), 
 * the corresponding polish notation is [* - 5 6 7] 
 * (which the return value should be ["*", "−", "5", "6", "7"]).
 * 
 * 1. build expression tree
 * 2. preorder traversal
 * 
 * @author jiashan
 */
public class ExpressionToPolish {

	public ArrayList<String> convertToPN(String[] expression) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		int val = 0;
		Integer base = 0;
		
		for (int i = 0; i <= expression.length; i++) {
			if (i != expression.length) {
				if (expression[i].equals("(")) {
					base += 10;
					continue;
				}
				
				if (expression[i].equals(")")) {
					base -= 10;
					continue;
				}
				val = getPriority(expression[i], base);
			}
			
			TreeNode right = i == expression.length ? new TreeNode(Integer.MIN_VALUE, "") : 
				new TreeNode(val, expression[i]);
			
			while (!stack.isEmpty()) {
				if (right.val <= stack.peek().val) {
					TreeNode node = stack.pop();
					
					if (stack.isEmpty()) {
						right.left = node;
					} else {
						TreeNode left = stack.peek();
						
						if (left.val < right.val) {
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
		
		ArrayList<String> polish = new ArrayList<String>();
		traversal(stack.peek().left, polish);
		
		return polish;
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
		if (a.equals("+") || a.equals("-")) {
			return 1 + base;
		}
			
		if (a.equals("*") || a.equals("/")) {
			return 2 + base;
		}

		return Integer.MAX_VALUE;
	}
	
	
	class TreeNode {
		public int val; 
		public String s;
		public TreeNode left, right;
		
		public TreeNode(int val, String ss) {
			this.val = val;
			this.s = ss;
			this.left = this.right = null;
		}
	}
}
