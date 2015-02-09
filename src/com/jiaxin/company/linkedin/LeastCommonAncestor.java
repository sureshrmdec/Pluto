package com.jiaxin.company.linkedin;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/**
 * Sample input:
 *
 *          1
 *         / \
 *        3   5
 *       / \   \
 *      2   4   7
 *     /     \
 *    9       8
 *
 * Expected output:
 *    2, 5 => 1
 *    2, 9 => 3
 *    ==========
 */
public class LeastCommonAncestor {
	// parent node way 
	public TreeNode lca(TreeNode node1, TreeNode node2) {
		List<TreeNode> list1 = getList(node1);
		List<TreeNode> list2 = getList(node2);
		
		int i;
		for (i = 0; i < list1.size() && i < list2.size() ; i++) {
			if (list1.get(i) != list2.get(i)) {
				return list1.get(i).parent;
			}
		}
		// if 2,9 => 3, use this. if 2,9 => 2.  just return list.get(i - 1) will never outOfBound 
		return i - 2 >= 0 ? list1.get(i - 2) : null;
	}
	
	
	private List<TreeNode> getList(TreeNode node) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		while (node != null) {
			list.add(0, node);
			node = node.parent;
		}
		
		return list;
	}

	/************************************************************************/
	// use recursive
	public TreeNode lcaNoParent(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null) {
			return null;
		}
		
		return getLCA(root, node1, node2);
	}
	
	private TreeNode getLCA(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null || root == node1 || root == node2) {
			return root;
		}
		
		TreeNode left = getLCA(root.left, node1, node2); 
		TreeNode right = getLCA(root.right, node1, node2);
		
		if (left != null && right != null) {
			return root;
		}
		
		if (left != null) {
			return left;
		}
		
		if (right != null) {
			return right;
		}
		
		return null; 
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
		
		node9.parent = node2; node8.parent = node4; node2.parent = node4.parent = node3;
		node7.parent = node5; node5.parent = node1; node3.parent = node1;	
	}
	

	// TreeNode
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		TreeNode (int x) {
			val = x;
		}
	}	
}
