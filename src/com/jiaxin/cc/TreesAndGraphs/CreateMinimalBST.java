package com.jiaxin.cc.TreesAndGraphs;

/**
 * 4.3 Given a sorted array, write a algorithm to create a binary search tree with minimal height;
 * 结合binary search, 中点为root, start, mid - 1用来构造左子树， mid + 1, end 用来构造右子树
 * 
 * @author jeffwan
 * @date May 6, 2014
 */
public class CreateMinimalBST {
	public TreeNode createMinimal(int[] A) {
	    if (A == null || A.length == 0) {
	        return null;
	    }
	    
	    return helper(A, 0, A.length - 1);
	}


	public TreeNode helper(int[] A, int start, int end) {
	    if (start > end) {
	        return null;
	    }

	    int mid = (start + end) / 2;
	    TreeNode root = new TreeNode(A[mid]);
	    
	    root.left = helper(A, start, mid - 1);
	    root.right = helper(A, mid + 1, end);

	    return root;
	}

	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}
}
