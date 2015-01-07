package com.jiaxin.lc.tree.traversal;


public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
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


	public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}

