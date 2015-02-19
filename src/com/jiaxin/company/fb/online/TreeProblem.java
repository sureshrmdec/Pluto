package com.jiaxin.company.fb.online;


/**
 *      4
 *    2   5
 *  1  3    6
 * 
 * 1. Greater value in BST
 * has right child -> return most left. 
 * no right child -> find parent. that current should be left child of that parent 
 * 
 * 
 * 2. Smaller value in BST (same to first one)
 * 
 * 3. Delete Node is BST
 * node has no child 
 * one child. just append
 * two child, get the leaf one, replace and sink
 * 
 * 
 * 
 * @author jiashan
 *
 */
public class TreeProblem {
	// 1. Greater value in BST
	public TreeNode greaterValueBST(TreeNode node) {
		if (node == null) {
			return null;
		}
		
		if (node.right != null) {
			node = node.right;
			while (node.left != null) {
				node = node.left;
			}
			return node;
		} else {
			while (node.parent != null && node.parent.right == node) {
				node = node.parent;
			}
			
			return node.parent;
		}
	}
	
	// 2. Smaller value in BST (same to first one)
	public TreeNode smallerValueBST(TreeNode node) {
		if (node == null) {
			return null;
		}
		
		if (node.left != null) {
			node = node.left;
			
			while (node.right != null) {
				node = node.right;
			}
			
			return node;
		} else {
			while (node.parent != null && node.parent.left == node) {
				node = node.parent;
			}
			return node.parent;
		}
	}
	
	
	// 3. Delete node is BST
    public TreeNode removeNode(TreeNode root, int value) {
		
    	
    	
    	return root;
    }
	
	
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		TreeNode(int x) { val = x; }
	}
}
