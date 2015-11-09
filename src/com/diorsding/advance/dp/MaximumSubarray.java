package com.diorsding.advance.dp;


/**
 * http://www.lintcode.com/en/problem/maximum-subarray/
 * 
 * Solution:
 * 1. State
 * local[i] means max value with ith.
 * global[i] means max value from (0 to i). 
 * 
 * 2. Function
 * local[i] = max(num[i], local[i - 1] + nums[i]); 
 * global[i] = max(local[i], global[i - 1]);
 * 
 * 3. local[0] = global[0] = nums[0]
 * 4. result = global[n - 1]
 * 
 * Optimization: rolling array, use two var to solve it. 
 * 
 * @author jiashan
 *
 */
public class MaximumSubarray {
	
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int[] local = new int[nums.length];
		int[] global = new int[nums.length];
		
		local[0] = nums[0];
		global[0] = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			local[i] = Math.max(nums[i], local[i - 1] + nums[0]);
			global[i] = Math.max(local[i], global[i - 1]);
		}
		
		return global[nums.length - 1];
	}
	
	public int maxSubArrayList(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int local = nums[0];;
		int global = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			local = Math.max(nums[i], local + nums[i]);
			global = Math.max(local, global);
		}
		
		return global;
	}
	
}
