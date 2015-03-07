package com.jiaxin.company.fb.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
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
    public boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0; 
		}
    	
    	if (p.length() == 1 || p.charAt(1) != '*') {
    		if (s.length() < 1) {
    			return false; 
    		}
    		
    		if (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.') {
    			return false; 
    		}
    		
    		return isMatch(s.substring(1), p.substring(1));
    	} else {
    		if (isMatch(s, p.substring(2))) {
    			return true;
    		}
    		
    		int i = 0; 
    		// if not same. isMatch(s, p.substring(2) this one will find out 
    		while (i < s.length() && (s.charAt(i) == p.charAt(0)) || p.charAt(0) == '.') {
    			if (isMatch(s.substring(i + 1), p.substring(2))) {
    				return true;
    			}
    			i++;
    		}
    	}
    	
    	return false;
    }
	
	
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
	public int stealMoney(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		int[] money = new int[A.length];
		money[0] = A[0];
		if (A.length == 1) {
			return money[0];
		}
		
		money[1] = Math.max(A[0], A[1]);
		if (A.length == 2) {
			return money[1];
		}
		
		// Could save memory to O(1) with using array. Like fibonacci
		for (int i = 2; i < A.length; i++) {
			money[i] = Math.max(money[i - 1], money[i - 2] + A[i]);
		}
		
		return money[A.length - 1];
	}
	
	public int maximumSum(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
			
		int include = A[0];
		int exclude = 0;
		System.out.println("exclude: " + exclude + " include: " + include);
		
		for (int i = 1; i < A.length; i++) {
			int lastInclude = include;
			include = exclude + A[i];
			exclude = Math.max(exclude, lastInclude);
			
			System.out.println("exclude: " + exclude + " include: " + include);
		}
		
		return Math.max(include, exclude);
	}
	
	
	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		printLevel(root);
		
		// p.length() == 1
		Assert.assertTrue(isMatch("a", "."));
		Assert.assertTrue(isMatch("a", "a"));
		Assert.assertFalse(isMatch("a", "b"));
		
		// p.charAt(1) != '*'
		Assert.assertFalse(isMatch("aab", "ab"));
		Assert.assertTrue(isMatch("aa", "a."));
		
		// p.charAt(1) == '*'
		Assert.assertTrue(isMatch("bca", "a*bca"));
		Assert.assertTrue(isMatch("bbbbca", "b*ca"));		
		Assert.assertTrue(isMatch("cbbca", ".*ca"));		
		
		
		int[] A = {5, 5, 10, 40, 50, 35};
		System.out.println(stealMoney(A));
		System.out.println(maximumSum(A));
	}
	
	
	// 5. Football Score
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
}
