package com.jiaxin.company.fb.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


/*
 * Initial Onsite: 
 * 1. Xml parse 
 * 2. Print tree by level 
 * 3. Regex
 * 
 * 
 * Onsite: 
 * 1. Find 3 ints that sum to 0 in an array (Jedi)  - Sum
 * 2. Given a list of a parties, can I attend all parties? (Ninja) -- check if they have intervals ? 
 * 3. Max non-adjacent subset sum (Ninja)
 * 4. Youtube typeahead (Pirate)
 * 5. Football scores (Ninja)
 */
public class Second {
	// 1. xml parse  - stack, queue? 
	
	
	// 2. print tree by levels -- Try DFS 
	public void printLevel(TreeNode root) {
		int height = getHeight(root);
		
		for (int i = 1; i <= height; i++) {
			print(root, i);
			System.out.println(" ");
		}
	}
	
	private void print(TreeNode root, int level) {
		if (root == null) {
			return;
		}
		
		if (level == 1) {
			System.out.print(root.val + " ");
		}
		
		print(root.left, level - 1);
		print(root.right, level - 1);
	}

	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		
		return Math.max(left, right) + 1;
	}

	// 3. regex
	
	
	
	// 1. Find 3 ints that sum to 0 in an array (Jedi)  - Sum
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if (num == null || num.length == 0) {
			return result;
		}
		
		Arrays.sort(num);
		
		for (int i = 0; i < num.length - 2; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
			}
			
			int left = i + 1;
			int right = num.length - 1;
			
			while (left < right) {
				int sum = num[i] + num[left] + num[right];
				
				if (sum == 0) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(num[i]);
					list.add(num[left]);
					list.add(num[right]);
					
					result.add(list);

					left++;
					right--;
					
					while (left < right && num[left] == num[left - 1]) {
						left++;
					}
					
					while (left < right && num[right] == num[right + 1]) {
						right--;
					}
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		
		return result;
    }
	
	// 2. If I can attend all parties? - see meeting special topic
	
	// 3. Max non-adjacent subset sum (Ninja) - DP -- same to thief problem? 
// http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
	
	
	
	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		printLevel(root);
	}
	
	
	// 5. Football Score
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
}
