package com.jiaxin.lc.newProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 * Cut right child, and connect with sibling as a left child.
 * @author jiashan
 *  1
 * 2 
 */
public class UpsideDownBinaryTree {
	int sum = 0;
	public int sumNumbers(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
//		helper(list, root);
		
		return 0;
	}
        
	
	
	public int kthSmallest(TreeNode root, int k) {
		if (root == null) {
			return 0;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int count = 0;
	
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			
			if (!stack.isEmpty()) {
				root = stack.pop();
				if (++count == k) {
					return root.val;
				}
				root = root.right;
			}
		}
		
		return 0;
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
