package com.jiaxin.cc.TreesAndGraphs;

import java.util.ArrayList;

/**
 * 4.9 You are given a binary tree in which each node contains a value. 
 * Design an algorithm to print all paths which sum to a given value. 
 * Note that a path can start or end anywhere in the tree.
 * 
 * 这题目一开始又理解错了，以为是Path Sum II. 暴力找sum路径，from root to leaf.
 * 实际上是 anywhere. -- 所以还没搞定....
 * 
 * @author jeffwan
 * @date May 6, 2014
 */
public class PathSum {
	
	// Path Sum II
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    
	    helper(result, list, root, sum);
	    
	    return result;
	}

	public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, 
	        TreeNode root, int sum) {
	    if (root == null) {
	        return;
	    }
	        
	    sum -= root.val;
	    
	    
	    if (root.left == null && root.right == null) {
	        if (sum == 0) {
	            list.add(root.val);
	            result.add(new ArrayList<Integer>(list));
	            list.remove(list.size() - 1);
	        } 
	        return;
	    }    
	    
	    list.add(root.val);
	    helper(result, list, root.left, sum);
	    helper(result, list, root.right, sum);
	    list.remove(list.size() - 1);    
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
