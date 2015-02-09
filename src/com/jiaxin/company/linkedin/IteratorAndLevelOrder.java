package com.jiaxin.company.linkedin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
 *    1
 *    3 5
 *    2 4 7
 *    9 8
 *    ==========
 */
public class IteratorAndLevelOrder {
	
	// BFS
	public void levelOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				root = queue.poll();
				System.out.print(root.val + " ");
				
				if (root.left != null) {
					queue.offer(root.left);
				}
				
				if (root.right != null) {
					queue.offer(root.right);
				}
			}
			System.out.println("\n");
		}
	}
	
	// Level order DFS
	public void levelOrderDFS(TreeNode root) {
		int height = getMaxHeight(root);
		
		for (int level = 1; level <= height; level++) {
			printLevel(root, level);
			System.out.println("\n");
		}
	}
	
	
	private void printLevel(TreeNode root, int level) {
		if (root == null) {
			return;
		}
		
		if (level == 1) {
			System.out.print(root.val + " ");
		} else {
			printLevel(root.left, level - 1);
			printLevel(root.right, level - 1);
		}
	}

	private int getMaxHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int left = getMaxHeight(root.left);
		int right = getMaxHeight(root.right);
		
		return Math.max(left, right) + 1;
	}


	/******************************************************************************/
	public class BSTIterator {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current; 
		
		public boolean hasNext() {
			return current != null || !stack.isEmpty();
		}
		
		public int next() {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			
			current = stack.pop();
			TreeNode node = current;
			current = current.right;
			
			return node.val;
		}
	}
	
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
		
		levelOrderDFS(node1);
	}
	
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
}
