package com.jiaxin.lc.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	
    	if (root == null) {
    		return result;
    	}
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	
    	while (!queue.isEmpty()) {
    		List<Integer> level = new ArrayList<Integer>();
    		int size = queue.size();
    		
    		for (int i = 0; i < size; i++) {
    			root = queue.poll();
    			level.add(root.val);
    			
    			if (root.left != null) {
    				queue.offer(root.left);
    			}
    			
    			if (root.right != null) {
    				queue.offer(root.right);
    			}
    		}
    		
    		result.add(0, level);
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
