package com.jiaxin.lc.tree.traversal;

import java.util.Stack;

public class TreeSeriaDeseria {
	public static void main(String[] args) {
		
	}
	
	public String serialization(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while (!stack.isEmpty() || root != null) {
			if (root == null) {
				sb.append("#");
			}
			
			while (root != null) {
				sb.append(root.val);
				stack.push(root);
				root = root.left;
			}
			
			if (!stack.isEmpty()) {
				root = stack.pop();
				root = root.right;
			}
		}
		
		return sb.toString();
	}
		
	public TreeNode deserialization(String string) {
		
		
		return null;
	}
	
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
