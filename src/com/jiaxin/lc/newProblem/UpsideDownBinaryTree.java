package com.jiaxin.lc.newProblem;

import org.junit.Test;

/**
 * Cut right child, and connect with sibling as a left child.
 * @author jiashan
 *  1
 * 2 
 */
public class UpsideDownBinaryTree {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
		TreeNode node = root;
		TreeNode parent = null;
		TreeNode parentRight = null;
		
		while (node != null) {
			TreeNode left = node.left;
			node.left = parentRight;
			parentRight = node.right;
			node.right = parent;
			parent = node;
			node = left;
		}
    	
    	return parent;
    }
        
    public TreeNode upsideDownBinaryTree3(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		if (root.left == null && root.right == null) {
			return root;
		}
    	
		TreeNode newRoot = upsideDownBinaryTree3(root.left);
		root.left.left = root.right;
		root.left.right = root;
		root.left = null;
		root.right = null;
				
    	return newRoot;
    }
    

    @Test
    public void test() {
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	
    	upsideDownBinaryTree3(root);
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
