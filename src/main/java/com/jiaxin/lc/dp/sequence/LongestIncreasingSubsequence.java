package com.jiaxin.lc.dp.sequence;

import org.junit.Test;

/**
 * Sequence DP.
 * 
 * State: f[i] first, the length of LIS. i will be end(this condition if very important) 
 * function: f[i] = max(f[j] + 1, j < i && A[j] < A[i])
 * initialize: f[0...n-1] = 1; 
 * answer: max(f[0...n-1])
 * 
 * Here: if f[i] means the length of LIS until i. the answer would be f[n - 1]. 
 * Different state function, different result.(Unfortunately, we can't do this way in this question)
 * 
 * O(n^2) or O(logN)
 * @author jiashan
 *
 */
public class LongestIncreasingSubsequence {
	public int longestIncreasingSubsequence(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int[] f = new int[nums.length];
		int max = 0;
		
		for (int i = 0; i < f.length; i++) {
			f[i] = 1; // Initialization. itself
			for (int j = 0; j < i; j++) {
				if (nums[j] <= nums[i]) {
					f[i] = Math.max(f[i], f[j] + 1); 
				}
			}
			max = Math.max(max, f[i]);
		}

		return max;
	}
	
	@Test
	public void test() {
		int[] nums1 = {5, 4, 1, 2, 3};     //3
		int[] nums2 = {4, 2, 4, 5, 3, 7};  //4
		
		System.out.println(longestIncreasingSubsequence(nums1));
		System.out.println(longestIncreasingSubsequence(nums2));
	}
}
