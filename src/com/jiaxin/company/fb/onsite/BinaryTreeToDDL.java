package com.jiaxin.company.fb.onsite;

import org.junit.Test;

/**
 * Binary Tree to List (not circle)
 * @author jiashan
 *
 */
public class BinaryTreeToDDL {
	
	public TreeNode binaryTree2List(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		root = binaryTree2ListUtil(root);
		
		while (root.left != null) {
			root = root.left;
		}
		
		return root;
	} 
	
	private TreeNode binaryTree2ListUtil(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		if (root.left != null) {
			TreeNode left = binaryTree2ListUtil(root.left);
			
			while (left.right != null) {
				left = left.right;
			}
			
			left.right = root;
			root.left = left;
		}
		
		if (root.right != null) {
			TreeNode right = binaryTree2ListUtil(root.right);
			
			while (right.left != null) {
				right = right.left;
			}
			
			right.left = root;
			root.right = right;
		}
		
		return root;
	}

	
	@Test
	public void test() {
		TreeNode node = new TreeNode(10);
		node.left = new TreeNode(12);
		node.right = new TreeNode(15);
		node.left.left = new TreeNode(25);
		node.left.right = new TreeNode(30);
		node.right.left = new TreeNode(36);
		
		TreeNode root = binaryTree2List(node);
		while (root != null) {
			System.out.print(root.val + " -> ");
			root = root.right;
		}
	}


	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val) { this.val = val; }
	}
}
