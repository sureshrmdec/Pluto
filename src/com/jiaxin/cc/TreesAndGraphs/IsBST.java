package com.jiaxin.cc.TreesAndGraphs;

import java.util.Stack;

/**
 * 4.5 Implement a function to check if a binary tree is a BST
 * Solution 1: inorder 看序列是否上升
 * Solution 2: recursive
 * 
 * @author jeffwan
 * @date May 6, 2014
 */
public class IsBST {
	//
	public boolean isBST(TreeNode root) {
	    if (root == null) {
	        return false;
	    }
	    
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode lastNode = null;
	    
	    while (root != null || !stack.isEmpty()) {
	        while (root != null) {
	            stack.push(root);
	            root = root.left;
	        }
	        
	        if (!stack.isEmpty()) {
	            root = stack.pop();
	            if (lastNode != null && lastNode.val > root.val) {
	                return false;
	            }
	            lastNode = root;
	            root = root.right;
	        }
	    }

	    return true;
	}
	
	// Recursive 
	public int lastValue = Integer.MIN_VALUE;
	public boolean isValidBST(TreeNode root) {
	    if (root == null) {
	        return true;
	    }

	    if (!isValidBST(root.left)) {
	        return false;
	    }
	    
	    if (root.val >= lastValue) {
	        return false;
	    }

	    lastValue = root.val;
	    
	    if (!isValidBST(root.right)) {
	        return false;
	    }
	    
	    return true;
	}
	
	
	// TreeNode
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}
}
