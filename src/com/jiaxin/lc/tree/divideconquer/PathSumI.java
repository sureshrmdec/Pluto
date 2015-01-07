package com.jiaxin.lc.tree.divideconquer;


public class PathSumI {
    public boolean hasPathSum(TreeNode root, int sum) {
    	if (root == null) {
    		return false;
    	}
    	
    	sum -= root.val;
    	
    	if (root.left == null && root.right == null) {
    		if (sum == 0) {
    			return true;
    		}
    	}
    	
    	boolean left = hasPathSum(root.left, sum);
    	boolean right = hasPathSum(root.right, sum);
    	
    	return left || right;
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
