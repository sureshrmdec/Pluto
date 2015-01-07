package com.jiaxin.lc.tree.traversal;

import java.util.LinkedList;
import java.util.Queue;

public class NextRightPointers {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				root = queue.poll();
				
				if (i == size - 1) {
					root.next = null;
				} else {
					root.next = queue.peek();
				}
				
				if (root.left != null) {
					queue.offer(root.left);
				}
				
				if (root.right != null) {
					queue.offer(root.right);
				}
			}
		}
    }
	
	
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
}
