package com.jiaxin.company.fb.onsite;

import com.jiaxin.company.fb.online.TreePath.TreeNode;

/**
 * 1. Nth Node in BST
 * 2. Next Node in BST
 * 3. LCA
 * 4. Flattern 
 * 5. BST To (Circular) Linked List
 * 
 * @author jiashan
 *
 */
public class FBTree {
	public TreeNode getNext(TreeNode root, int val) {
		TreeNode next = null;
		while (root != null) {
			if (root.val <= val) {
				root = root.right;
			} else {
				next = root;
				root = root.left;
			}
		}
		return next;
	}

	public TreeNode getPrev(TreeNode root, int val) {
		TreeNode prev = null;
		while (root != null) {
			if (root.val >= val) {
				root = root.left;
			} else {
				prev = root;
				root = root.right;
			}
		}
		return prev;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
