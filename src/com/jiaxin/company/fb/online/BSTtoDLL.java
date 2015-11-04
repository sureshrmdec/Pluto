package com.jiaxin.company.fb.online;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


/**
 * 
 * Given an ordered binary tree, recursively change it into a circular doubly linked list which is returned
 * 
 * http://mattcb.blogspot.com/2012/10/bst-to-ddl.html
 * 
 * @author jiashan
 *
 */
public class BSTtoDLL {

	public TreeNode convertToCircular(TreeNode root) {
		if (root == null) {
			return null; 
		}
		
		TreeNode left = convertToCircular(root.left);
		TreeNode right = convertToCircular(root.right);
		
		if (left == null && right == null) {
			root.left = root;
			root.right = right; 
			return root;
		}
		
		TreeNode tail = right == null ? null : right.left;
		
		// join left to root
		if (left == null) {
			concat(right.left, root);
		} else {
			concat(left.left, root);
		}
		
		// join right to root
		if (right == null) {
			concat(root, left);
		} else {
			concat(root, right);
		}
		
		// Join right to left
		if (left != null && right != null) {
			concat(tail, left);
		}
		
		return left == null ? root : left;
	}
	
	public void concat(TreeNode node1, TreeNode node2) {
		node1.right = node2;
		node2.left = node1;
	}
	
	@Test
	public void test() {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2); 
		node.right = new TreeNode(5);
		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(3);
		node.right.right = new TreeNode(6);
		node.left.left.left = new TreeNode(0);
		
		System.out.println(levelOrderDFS2(node));
		TreeNode newHead = convertToCircular(node);
//		printList(newHead);
	}
		
	public void printList(TreeNode newHead) {
		
		while (newHead != null) {
			System.out.print(newHead.val + " -> ");
			newHead = newHead.right;
		}
		
	}

	// Level Order DFS
	public List<List<Integer>> levelOrderDFS2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(result, root, 1);
	
		return result;
	}
	
	private void helper(List<List<Integer>> result, TreeNode root, int level) {
		if (root == null) {
			return;
		}
			
		if (result.size() < level) {
			result.add(new ArrayList<Integer>());
		}
			
		result.get(level - 1).add(root.val);
		helper(result, root.left, level + 1);
		helper(result, root.right, level + 1);
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		TreeNode(int x) { val = x; }
	}
}
