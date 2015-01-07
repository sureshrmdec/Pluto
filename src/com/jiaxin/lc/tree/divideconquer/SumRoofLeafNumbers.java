package com.jiaxin.lc.tree.divideconquer;

import java.util.ArrayList;
import java.util.List;


public class SumRoofLeafNumbers {
	int sum = 0;
	public int sumNumbers(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		
		helper(list, root);
		
		return sum;
	}

	private void helper(List<Integer> list, TreeNode root) {
		if (root == null) {
			return;
		}
		
		if (root.left == null && root.right == null) {
			list.add(root.val);
			sum += getListValue(list);
			list.remove(list.size() - 1);
			return;
		}
		
		list.add(root.val);
		helper(list, root.left);
		helper(list, root.right);
		list.remove(list.size() - 1);
	}

	private int getListValue(List<Integer> list) {
		int value = 0;
		for (int i = 0; i < list.size(); i++) {
			value = value * 10 + list.get(i);
		}
		
		return value;
 	}



	public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
