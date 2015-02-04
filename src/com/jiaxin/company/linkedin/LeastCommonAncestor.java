package com.jiaxin.company.linkedin;

import java.util.ArrayList;
import java.util.List;

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
		
		return list1.get(i - 1);
	}
	
	
	private List<TreeNode> getList(TreeNode node) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		while (node != null) {
			list.add(0, node);
			node = node.parent;
		}
		
		return list;
	}

	public TreeNode lcaNoParent(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null) {
			return null;
		}
		
		return getLCA(root, node1, node2);
	}
	
	// use recursive
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
