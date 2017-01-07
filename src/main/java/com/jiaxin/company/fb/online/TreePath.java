package com.jiaxin.company.fb.online;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TreePath {
	public List<List<Integer>> path(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> list = new ArrayList<Integer>();
    	
    	helper(result, list, root);
    	
    	return result;
	}
	
	private void helper(List<List<Integer>> result, List<Integer> list, TreeNode root) {
		if (root == null) {
			return;
		}
		
		if (root.left == null && root.right == null) {
			list.add(root.val);
			result.add(new ArrayList<Integer>(list));
			list.remove(list.size() - 1);
		}
		
		list.add(root.val);
		helper(result, list, root.left);
		helper(result, list, root.right);
		list.remove(list.size() - 1);
	}
	
	@Test
	public void test() {
		TreeNode node5 = new TreeNode(5);
		TreeNode node4 = new TreeNode(4);
		TreeNode node8 = new TreeNode(8);
		TreeNode node11 = new TreeNode(11);
		TreeNode node13 = new TreeNode(13);
		TreeNode node44 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node2 = new TreeNode(2);
		TreeNode node55 = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);
		
		node5.left = node4; node5.right = node8;
		node4.left = node11; node8.left = node13; node8.right = node44;
		node11.left = node7; node11.right = node2; node44.left = node55; node44.right = node1;
		
		System.out.println(path(node5));
	}
	
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
