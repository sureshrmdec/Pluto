package com.jiaxin.company.linkedin;


public class SymmetricTree {
	public boolean isSymmetricTree(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		return helper(root.left, root.right);
	}
	
	private boolean helper(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		
		if (left == null || right == null || left.val != right.val) {
			return false;
		}
		
		boolean leftResult = helper(left.left, right.right);
		boolean rightResult = helper(left.right, right.left);
		
		return leftResult && rightResult;
	}
	
	

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}	
}
