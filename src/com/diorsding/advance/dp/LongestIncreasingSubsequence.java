package com.diorsding.advance.dp;

import org.junit.Test;

/**
 * http://www.lintcode.com/en/problem/longest-increasing-subsequence/
 * 
 * Challenge: Time complexity O(n^2) or O(nlogn)
 * 
 * Wrong solution: two pass. left -> right, right -> left. find increasing sequence.
 * But the problem is subsequence. not subarray!
 * 
 * Solution: DP
 * 1. f[i] longest subsequence end with nums[i]. 
 * 2. f[i] = max{f[i], f[j] + 1} 0 <= j < i && A[j] < A[i]. Our goal is to find a j, so need iterate 0 -> i-1. 
 * 3. f[i] = 1. As end with nums[i], anywhere the initial state in this array is 1.   
 * 4. max{f[i]}.
 * 
 * @author jiashan
 *
 */
public class LongestIncreasingSubsequence {

	public int longestIncreasingSubsequence(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int result = 0;
		
		// Initialization, which can be put in for loop.
		int[] f = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			f[i] = 1;
		}
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] >= nums[j]) {
					f[i] = Math.max(f[i], f[j] + 1);  // f[j] is calculate in previous steps
				}
			}
			
			result = Math.max(result, f[i]);
		}
		
		return result;
	}
	
	@Test
	public void test() {
//		int[] nums = {5, 4, 1, 2, 3};
		int[] nums = {4, 2, 4, 5, 3, 7};
		
		System.out.println(longestIncreasingSubsequence(nums));
	}
	
}
