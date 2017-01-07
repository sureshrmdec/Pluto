package com.jiaxin.lc.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (root == null) {
    		return result;
    	}
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	boolean normalOrder = true;
    	
    	while (!queue.isEmpty()) {
    		List<Integer> level = new ArrayList<Integer>();
    		int size = queue.size();
    		
    		for (int i = 0; i < size; i++) {
    			root = queue.poll();
    			if (normalOrder) {
    				level.add(root.val);
    			} else {
    				level.add(0, root.val);
    			}
    			
    			if (root.left != null) {
    				queue.offer(root.left);
    			}
    			
    			if (root.right != null) {
    				queue.offer(root.right);
    			}
    		}
    		
    		normalOrder = !normalOrder;
    		result.add(level);
     	}
    	
    	return result;
    }
    
    public List<List<Integer>> zigzagLevelOrderTwoStack(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (root == null) {
    		return result;
    	}
    	
    	Stack<TreeNode> curLevel = new Stack<TreeNode>();
    	Stack<TreeNode> nextLevel = new Stack<TreeNode>();
    	
    	curLevel.add(root);
    	boolean normalOrder = true;
    	
    	while (!curLevel.isEmpty()) {
    		List<Integer> level = new ArrayList<Integer>();
    		
    		while (!curLevel.isEmpty()) {
    			root = curLevel.pop();
    			level.add(root.val);
    			
    			if (normalOrder) {
    				if (root.left != null) {
    					curLevel.add(root.left);
    				}

    				if (root.right != null) {
    					curLevel.add(root.right);
    				}
    			} else {
    				if (root.right != null) {
    					curLevel.add(root.right);
    				}
    				
    				if (root.left != null) {
    					curLevel.add(root.left);
    				}
    			}
    		}
    		
    		result.add(level);
    		curLevel = nextLevel;
    		nextLevel = new Stack<TreeNode>();
    		normalOrder = !normalOrder;
    	}
    	
    	return result;
    }
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
