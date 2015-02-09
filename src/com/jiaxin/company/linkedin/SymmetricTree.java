package com.jiaxin.company.linkedin;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class SymmetricTree {
	public boolean isSymmetricTree(TreeNode root) {
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
	
	
	// Reflection Tree? -> Mirror of binary tree
	// preorder traversal, and swap left & right for every nodes
	public TreeNode mirrorTree(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return root;
		}
		
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		if (root.left != null) {
			mirrorTree(root.left);
		}
		
		if (root.right != null) {
			mirrorTree(root.right);
		}
		
		return root;
	}
	
	
	public void levelOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				root = queue.poll();
				System.out.print(root.val + " ");
				
				if (root.left != null) {
					queue.offer(root.left);
				}
				
				if (root.right != null) {
					queue.offer(root.right);
				}
			}
			System.out.println("\n");
		}
	}
	
	/*
	 *          1
	 *         / \
	 *        3   5
	 *       / \   \
	 *      2   4   7
	 *     /     \
	 *    9       8
	 */
	
	@Test
	public void test() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		node1.left = node3; node1.right = node5;
		node3.left = node2; node3.right = node4; node5.right = node7;
		node2.left = node9; node4.right = node8;
		
		levelOrder(node1);
		
		levelOrder(mirrorTree(node1));
	}
	
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}	
}
