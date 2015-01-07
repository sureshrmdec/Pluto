package com.jiaxin.lc.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class InorderTraversal {
	public List<Integer> inorderTraversalRecursive(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		traversal(result, root);
		return result;
    }
	
	private void traversal(List<Integer> result, TreeNode root) {
		if (root == null) {
			return;
		}
		
		traversal(result, root.left);
		result.add(root.val);
		traversal(result, root.right);
	}

	
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			
			if (!stack.isEmpty()) {
				root = stack.pop();
				result.add(root.val);
				root = root.right;
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
