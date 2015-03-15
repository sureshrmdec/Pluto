package com.jiaxin.company.fb.round1;

import org.junit.Test;


/*
 * Phone:
 * 1. Git bisect 
 * 2. Longest path in a binary tree. 
 * 
 * 
 * Onsite:
 * 1. Jedi skip coding questions.
 * 2. Compute whether a string is a palindrome, ignoring whitespace, punctuation and capitalization. (Ninja) 
 * 3. Fill a rectangle within a 8-bit image buffer. (Ninja)
 * 4. Design hypershell (Pirate)
 * 5. Group-by-equality (Ninja)
 * 6. Group-by-anagram (Ninja)
 * 7. number of interpretations (Ninja) 
 */
public class Sixth {
	// 1. Git bisect
	public int gitBisect(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("can not be true");
		}
		
		int start = 1;
		int end = n;
		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			
			if (isBadVersion(mid)) {
				end = mid;
			} else {
				start = mid;
			}
		}
		
		if (isBadVersion(start)) {
			return start;
		}
		
		if (isBadVersion(end)) {
			return end;
		}
		
		return -1;
	}
	
	// API function
	public boolean isBadVersion(int k) {
		return k >= 1;
	}
	
	// 2. Longest Path in a binary tree -- not maxPathSum 
	// solution: maxLeft + maxRight + 1 (wrong) --> campare singlePath & maxPath
	
	public int longestPath(TreeNode root) {
		ResultType result = helper(root);
		return result.max;
	}

	private ResultType helper(TreeNode root) {
		if (root == null) {
			return new ResultType(0, 0);
		}
		
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		
		int single = Math.max(left.single, right.single) + 1;
		int max = Math.max(left.max, right.max);
		max = Math.max(max, left.single + right.single + 1);
		
		return new ResultType(single, max);
	}

	class ResultType {
		int single; 
		int max;
		public ResultType(int single, int max) {
			this.single = single;
			this.max = max;
		}
	}

	@Test
	public void test() {
		System.out.println(gitBisect(2));
		System.out.println(gitBisect(10));
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(3);
		root.left.right = new TreeNode(3);
		root.left.right.right = new TreeNode(3);
		root.left.right.right.right = new TreeNode(3);
		root.right = new TreeNode(4);
		
		
		System.out.println(longestPath(root));
	}
	
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
