package com.jiaxin.cc.TreesAndGraphs;


/**
 * 4.8 You have two very large binary trees: T1. with millions of nodes, and T2, with hundreds of nodes, 
 * Create an algorithm to decide if T2 is a subtree if T1.
 * 
 * 思路:
 * 先比看root.value 是否相同，
 * 		是, 用matchTree来匹配
 * 			比如value 相同，左右都match才OK
 * 		否, 递归调用subTree(left, t2) || subTree(right, t2);
 * 
 * 注意一些边界的判断条件
 * 
 * 
 * @author jeffwan
 * @date May 6, 2014
 */
public class ContainsTree {
	public boolean containsTree(TreeNode t1, TreeNode t2) {
	    if (t2 == null) {
	        return true;
	    }    

	    return subTree(t1, t2);
	}


	public boolean subTree(TreeNode t1, TreeNode t2) {
	    if (t1 == null) {
	        return false;
	    }

	    if (t1.val == t2.val) {
	        return matchTree(t1, t2);
	    }
	    
	    return (subTree(t1.left, t2) || subTree(t2.right, t2));
	}

	public boolean matchTree(TreeNode t1, TreeNode t2) {
	    if (t1 == null && t2 == null) {
	        return true;
	    }
	    
	    if (t1 == null || t2 == null) {
	        return false;
	    }
	    
	    if (t1.val != t2.val) {
	        return false;
	    } 
	    
	    return (matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right));
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
