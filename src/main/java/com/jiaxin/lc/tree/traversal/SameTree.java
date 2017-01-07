package com.jiaxin.lc.tree.traversal;


public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		
		if (p == null || q == null || p.val == q.val) {
			return false;
		}
		
		boolean left = isSameTree(p.left, q.right);
		boolean right = isSameTree(p.right, q.right);
		
		return left && right;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
