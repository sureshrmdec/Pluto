package com.jiaxin.lc.tree.divideconquer;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> list = new ArrayList<Integer>();
    	
    	helper(result, list, root, sum);
    	
    	return result;
    }

	private void helper(List<List<Integer>> result, List<Integer> list, TreeNode root, int sum) {
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
		}
		
		list.add(root.val);
		helper(result, list, root.left, sum);
		helper(result, list, root.right, sum);
		list.remove(list.size() - 1);
	}


	public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
