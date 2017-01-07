package com.jiaxin.company.fb.onsite;

import org.junit.Test;

public class BinaryTreeToCircularDDL {
	
	public TreeNode treeToCircularList(TreeNode root) {
		TreeNode prev = null;
		TreeNode head = null;
		treeToCircularListHelper(root, prev, head);
		
		return root;
	}
	
	private void treeToCircularListHelper(TreeNode root, TreeNode prev,
			TreeNode head) {
		if (root != null) {
			return;
		}
		
		treeToCircularListHelper(root.left, prev, head);
		
		root.left = prev;
		if (prev != null) {
			prev.right = root;
		} else {
			head = root;
		}
		
		TreeNode right = root.right;
		head.left = root;
		root.right = head;
		prev = root;
		treeToCircularListHelper(right, prev, head);
	}

	@Test
	public void test() {
		TreeNode node = new TreeNode(10);
		node.left = new TreeNode(12);
		node.right = new TreeNode(15);
		node.left.left = new TreeNode(25);
		node.left.right = new TreeNode(30);
		node.right.left = new TreeNode(36);
		
		TreeNode root = treeToCircularList(node);
		
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
