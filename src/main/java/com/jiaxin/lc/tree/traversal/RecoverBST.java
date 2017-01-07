package com.jiaxin.lc.tree.traversal;


public class RecoverBST {
	public TreeNode firstNode = null;
	public TreeNode secondNode = null;
	public TreeNode lastNode = new TreeNode(Integer.MIN_VALUE);
	
	public void recoverTree(TreeNode root) {
		traversal(root);
		
		int temp = firstNode.val;
		firstNode.val = secondNode.val;
		secondNode.val = temp;
	}

	private void traversal(TreeNode root) {
		if (root == null) {
			return;
		}
		
		traversal(root.left);
		
		if (firstNode == null && lastNode.val > root.val) {
			firstNode = lastNode;
		}
		
		if (firstNode != null && lastNode.val > root.val) {
			secondNode = root;
		}
		
		lastNode = root;
		traversal(root.right);
	}


	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
