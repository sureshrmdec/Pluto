package com.jiaxin.lc.tree.traversal;


public class FlattenTreeToList {
	public TreeNode lastNode;
	
	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		
		if (lastNode != null) {
			lastNode.left = null;
			lastNode.right = root;
		}
		
		lastNode = root;
		TreeNode right = root.right;
		flatten(root.left);
		flatten(right);
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
