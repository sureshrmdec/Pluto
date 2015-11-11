package com.diorsding.advance.datastructure;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;


/**
 * http://www.lintcode.com/en/problem/expression-evaluation/
 * Given an expression string array, return the final result of this expression
 * For the expression 2*6-(23+7)/(1+2), return 2. Input is String[]
 * 
 * 1. build expression tree. 
 * 2. post order traversal -> reverse polish
 * 3. reverse polish calculation.
 * 
 * 
 * @author jiashan
 *
 */
public class ExpressionEvaluation {
	
	public int evaluateExpression(String[] expression) {
		if (expression == null || expression.length == 0) {
			return 0;
		}
		
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
		
		ArrayList<String> reversePolish = new ArrayList<String>();
		traversal(stack.peek().left, reversePolish);
		
		int result = calculateRPN(reversePolish);
		return result;
    }
	
	private int calculateRPN(ArrayList<String> reversePolish) {
		Stack<Integer> stack = new Stack<Integer>();
		
		for (String exp : reversePolish) {
			if ("+-*/".contains(exp)) {
				int b = stack.pop();
				int a = stack.pop();
				
				int result = 0;
				
				switch (exp) {
					case "+":
						result = a + b;
						break;
					case "-":
						result = a - b;
						break;
					case "*":
						result = a * b;
						break;
					case "/":
						result = a / b;
						break;
				}
				
				stack.push(result);
			} else {
				stack.push(Integer.parseInt(exp));
			}
		}
		
		return stack.isEmpty() ? 0 : stack.peek();
	}

	private void traversal(TreeNode root, ArrayList<String> list) {
		if (root == null) {
			return;
		}
		
		if (root.left != null) {
			traversal(root.left, list);
		}
		
		if (root.right != null) {
			traversal(root.right, list);
		}
		
		list.add(root.s);
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
	
	@Test
	public void test() {
		String[] expression = {"(","(","(","(","(",")",")",")",")",")"};
		
		System.out.println(evaluateExpression(expression));
	}
}
