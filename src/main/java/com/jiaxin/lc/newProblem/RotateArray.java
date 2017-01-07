package com.jiaxin.lc.newProblem;

import org.junit.Test;


/**
 * 1. rotate arrays. 5 6 7 1 2 3 4 -> 1 2 3 4 5 6 7. 
 * reverse left part, reverse right part. and reverse all.
 * 
 * 2. rotate arrays. 1 2 3 4 5 6 7 -> 5 6 7 1 2 3 4 (n = 7, k = 4) same progress 
 * 
 * 2. Leetcode give K ask rotate. 
 * 
 * n = 7, k = 3 (in-place)
 * 1 2 3 4 5 6 7. 
 * 5 6 7 1 2 3 4.
 * 
 * @author jiashan
 *
 */
public class RotateArray {
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return;
		}
		
		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}
	
	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
	
	@Test
	public void test() {
		int[] nums = {1,2,3};
		rotate(nums, 4);
		
		for (int num :  nums) {
			System.out.print(num + ",");
		}
	}
}
