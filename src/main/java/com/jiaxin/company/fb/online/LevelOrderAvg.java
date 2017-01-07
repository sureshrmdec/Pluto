package com.jiaxin.company.fb.online;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;


public class LevelOrderAvg {
	// Level Order DFS
	public List<List<Integer>> levelOrderDFS2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(result, root, 1);
	
		// calculate avg for each level? -- need to talk about
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
	
	// Level Order avg - BFS
	public List<Integer> levelOrderAvg(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			int sum = 0;
			
			for (int i = 0; i < size; i++) {
				root = queue.poll();
				sum += root.val;
				
				if (root.left != null) {
					queue.offer(root.left);
				}
				
				if (root.right != null) {
					queue.offer(root.right);
				}
			}
			
			result.add(sum / size);
		}
		
		return result;
	}
	
	// Level Order avg - DFS
	public List<Integer> levelOrderAvgDFS(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		helperDFS(result, root, 1);
	
		return result;
	}
	
	private void helperDFS(List<Integer> result, TreeNode root, int level) {
		if (root == null) {
			return;
		}
			
		if (result.size() < level) {
			result.add(0);
		}
			
		result.set(level - 1, result.get(level - 1) + root.val);
		helperDFS(result, root.left, level + 1);
		helperDFS(result, root.right, level + 1);
	}
	
	@Test
	public void test() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		node1.left = node3; node1.right = node5;
		node3.left = node2; node3.right = node4; node5.right = node7;
		node2.left = node9; node4.right = node8;
		
//		System.out.println((node1));
		System.out.println(levelOrderAvg(node1));
		System.out.println(levelOrderAvgDFS(node1));
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
