package com.jiaxin.cc.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 4.4 Given a binary tree, design an algorithm which create a linked list of all the nodes at each path.
 * 
 * 这题目一开始没看懂，后来才发现，这是Leetcode 那道level上node相连的题目, BFS就可以了
 * 这题目也不用自己创建ListNode了，直接返回LinkedList就可以
 * 
 * @author jeffwan
 * @date May 6, 2014
 */
public class CreateLevelLinkesList {
	public ArrayList<LinkedList<TreeNode>> createPath(TreeNode root) {
	    ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
	    if (root == null) {
	        return result;
	    }
	    
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.offer(root);
	    
	    while (!queue.isEmpty()) {
	        int size = queue.size();
	        LinkedList<TreeNode> level = new LinkedList<TreeNode>();
	        for (int i = 0; i < size; i++) {
	            TreeNode temp = queue.poll();
	            level.add(temp);
	            
	            if (temp.left != null) {
	                queue.offer(temp.left);
	            }
	            
	            if (temp.right != null) {
	                queue.offer(temp.right);
	            }
	        }
	        result.add(level);
	    }
	    return result;
	}
	
	// TreeNode
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			val = x;
		}
	}
}
