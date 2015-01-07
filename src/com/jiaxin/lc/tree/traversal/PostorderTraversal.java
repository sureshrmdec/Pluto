package com.jiaxin.lc.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		if (root == null) {
			return result;
		}
		
		stack.push(root);
		
		while (!stack.isEmpty()) {
			TreeNode next = stack.peek();
			
			if (next.left == null || next.right == null || (next.left == null && next.right == null)) {
				next = stack.pop();
				result.add(next.val);
				root = next;
				
			} else {
				if (next.right != null) {
					stack.push(next.right);
				}
				
				if (next.left != null) {
					stack.push(next.left);
				}
			}
		}
		
		return result;
	}
	
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
