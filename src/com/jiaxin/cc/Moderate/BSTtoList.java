package com.jiaxin.cc.Moderate;

/**
 * 17.13 BiNode could be used to represend both a binary tree or a doubly linked list.  
 * Implement a menthod to convert a BST into a doubly linked List.(Values should be kept in order. in place)
 * 
 * 如果是Interactive的递归思路，那就一个一个的接上，但是如果是recursive就补应该这个思想了，应该是
 * 1. 拆出来left，拆出来right
 * 2. 分别和 root相连
 * 
 * @author jeffwan
 * @date May 24, 2014
 */
public class BSTtoList {
	public BiNode bstToList(BiNode root) {
		if (root == null) {
			return null;
		}
		
		BiNode left = bstToList(root.node1);
		BiNode right = bstToList(root.node2);
		// concat left and root
		if (left != null) {
			while (left.node2 != null) {
				left = left.node2;
			}
			
			left.node2 = root;
			root.node1 = left;
		}

		// concat right and root
		if (right != null) {
			root.node2 = right;
			right.node1 = root;
		}
		
		return left != null ? left : root;
	}

	public class BiNode {
		public BiNode node1, node2;
		public int data;
	}
}
