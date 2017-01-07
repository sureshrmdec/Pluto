package com.jiaxin.lc.tree.traversal;


public class ValidateBST {    
	public TreeNode lastNode = null;
	
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		if (!isValidBST(root.left)) {
			return false;
		}
		
		if (lastNode != null && lastNode.val > root.val) {
			return false;
		}
		
		lastNode = root;
		if (!isValidBST(root.right)) {
			return false;
		}
		
		return true;
     }
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
