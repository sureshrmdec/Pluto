package com.jiaxin.lc.tree.divideconquer;


public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
    	ResultType result = helper(root);
    	
    	return result.maxPath;
    }
	
    private ResultType helper(TreeNode root) {
		if (root == null) {
			return new ResultType(0, Integer.MIN_VALUE);
		}
		
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		
		int singlePath = Math.max(left.singlePath, right.singlePath);
		singlePath = Math.max(singlePath, 0);
		
		int maxPath = Math.max(left.maxPath, right.maxPath);
		maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);
		
		return new ResultType(singlePath, maxPath);
	}

	private class ResultType {
    	int singlePath;
    	int maxPath;
    	ResultType(int singlePath, int maxPath) {
    		this.singlePath = singlePath;
    		this.maxPath = maxPath;
    	}
    }
    
	public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
