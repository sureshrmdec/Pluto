package com.jiaxin.cc.TreesAndGraphs;

import java.util.ArrayList;

/**
 * 4.7 Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 * Avoid storing addtional nodes in a data structure. NOTE:This is not necessarily a binary search tree. 
 * 
 * 这题跟之前有些不同，有follow up
 * 1. follow up 是 如果没有parent 节点呢？ 如果没有parent节点就一定得给root节点，其实这题也讲了，平时我没写而已
 * 2. Avoid 存储, 也就是说我常用的存Path那种方法可能不行. 
 * 
 * @author jeffwan
 * @date May 6, 2014
 */
public class LastestCommonAncestor {
	public TreeNode commonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
	    if (root == null) {
	        return null;
	    }

	    return getAncestor(root, node1, node2);
	}

	public TreeNode getAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
	    if (root == null || root == node1 || root == node2) {
	        return root; 
	    }

	    TreeNode left = getAncestor(root.left, node1, node2);
	    TreeNode right = getAncestor(root.right, node1, node2);
	    
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
	
	
	public TreeNode lastCommonAncestor2(TreeNode node1, TreeNode node2) {
		if (node1 == null || node2 == null) {
			return null;
		}

		ArrayList<TreeNode> list1 = getPath2Root(node1);
		ArrayList<TreeNode> list2 = getPath2Root(node2);
		

		int i, j;
		for (i = list1.size() - 1, j = list2.size() - 1; i >= 0 && j >= 0; i--, j--) {
			if (list1.get(i) != list2.get(j)) {
				return list1.get(i).parent; 
			}
		}

		return list1.get(i + 1);

	}

	private ArrayList<TreeNode> getPath2Root(TreeNode node) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();

		while(node != null) {
			list.add(node);
			node = node.parent;
		}

		return list;
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
