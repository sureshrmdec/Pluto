package com.diorsding.advance.datastructure;

import java.util.Stack;


/**
 * http://www.lintcode.com/en/problem/expression-tree-build/
 * 
 * For the expression (2*6-(23+7)/(1+2)) 
 * (which can be represented by ["2" "*" "6" "-" "(" "23" "+" "7" ")" "/" "(" "1" "+" "2" ")"]).
 * 
 * @author jiashan
 *
 */
public class ExpressionTreeBuild {
	
	public ExpressionTreeNode build(String[] expression) {
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
						right.root.left = node.root;
					} else {
						TreeNode left = stack.peek();
						
						if (left.val < right.val) {
							right.root.left = node.root;
						} else {
							left.root.right = node.root;
						}
					}
					
				} else {
					break;
				}
			}
			
			stack.push(right);
			
		}
				
		return stack.peek().root.left;
    }
	
	private int getPriority(String string, Integer base) {
		if (string.equals("+") || string.equals("-")) {
			return 1 + base;
		}
		
		if (string.equals("*") || string.equals("/")) {
			return 2 + base;
		}
		
		return Integer.MAX_VALUE;
	}

	public class ExpressionTreeNode {
		public String symbol;
		public ExpressionTreeNode left, right;
		public ExpressionTreeNode(String symbol) {
			this.symbol = symbol;
			this.left = this.right = null;
		}
	}
	
	
	class TreeNode {
		public int val; 
		public String s;
		public ExpressionTreeNode root;
		
		public TreeNode(int val, String ss) {
			this.val = val;
			this.root = new ExpressionTreeNode(ss);
		}
	}
}
