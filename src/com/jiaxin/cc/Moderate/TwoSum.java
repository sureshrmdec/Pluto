package com.jiaxin.cc.Moderate;

import java.util.Arrays;

/**
 * 17.12 Design an algorithm to find all pairs of integers within an array which sum to a specified value
 * 
 * Solution: 不是sorted, 如果暴力是 O(n^2). 我们sort一下用two pointer. O(nlogn).
 * 
 * @author jeffwan
 * @date May 24, 2014
 */
public class TwoSum {
	public void twoSum(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return;
		}
		
		Arrays.sort(nums);
		int start = 0;
		int end = nums.length - 1;
		
		while (start < end) {
			int sum = nums[start] + nums[end];
			if (sum  == target) {
				start++;
				end--;
				System.out.println(start + " " + end);
			} else if (sum < target) {
				start++;
			} else {
				end--;
			}
		}
	}
}
