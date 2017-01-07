package com.jiaxin.lc.tree.divideconquer;


public class MaxDepth {
    public int maxDepth(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	
    	int left = maxDepth(root.left);
    	int right = maxDepth(root.right);
    	
    	return Math.max(left, right) + 1;
    }
    
	public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
