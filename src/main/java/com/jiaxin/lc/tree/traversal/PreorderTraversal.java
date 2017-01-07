package com.jiaxin.lc.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class PreorderTraversal {
	public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
		
        traversal(result, root);
        
        return result;
    }
	
	private void traversal(List<Integer> result, TreeNode root) {
		if (root == null) {
			return;
		}
		
		result.add(root.val);
		traversal(result, root.left);
		traversal(result, root.right);
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				result.add(root.val);
				stack.push(root);
				root = root.left;
			}
			
			if (!stack.isEmpty()) {
				root = stack.pop();
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
