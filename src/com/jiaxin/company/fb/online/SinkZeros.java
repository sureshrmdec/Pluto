package com.jiaxin.company.fb.online;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class SinkZeros {
	public void sinkTree(TreeNode root) {
	        if(root == null) return;
	        if(root.val == 0) {
	            TreeNode toSwap = findSwapNode(root);
	            if(toSwap != null) {
	                int temp = root.val;
	                root.val = toSwap.val;
	                toSwap.val = temp;
	            } else return;
	        }
	        sinkTree(root.left);
	        sinkTree(root.right);
	    }
	
	private TreeNode findSwapNode(TreeNode root) {
		if (root == null)
			return null;
		if (root.val != 0)
			return root;
		TreeNode ret = findSwapNode(root.left);
		if (ret != null)
			return ret;
		return findSwapNode(root.right);
	}
	
	@Test
	public void test() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(0);
		TreeNode node4 = new TreeNode(0);
		TreeNode node5 = new TreeNode(0);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		node1.left = node3; node1.right = node5;
		node3.left = node2; node3.right = node4; node5.right = node7;
		node2.left = node9; node4.right = node8;
		
		System.out.println(levelOrderDFS2(node1));
		sinkTree(node1);
		System.out.println(levelOrderDFS2(node1));
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
		
		TreeNode(int val) {
			this.val = val;
		}
	}
}
