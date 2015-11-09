package com.diorsding.advance.dp;

/**
 * http://www.lintcode.com/en/problem/maximum-product-subarray/
 * 
 * Solution:
 * 1. State
 * min[i] minimum product in (0, i), ith included
 * max[i] maximum product in (0, i), ith included
 * 2. Function
 * min[i] = min(nums[i], min(min[i - 1] * nums[i], max[i - 1] * nums[i]))
 * max[i] = max(nums[i], max(max[i - 1] * nums[i], min[i - 1] * nums[i]))
 * global = Max(global[i - 1], max[i])
 * 3. 
 * min[0] = max[0] = nums[0]
 * 4. result = global[n - 1]
 * 
 * Optimization: no need to use min[] & max[] as storage, two vars are enough. 
 * 
 * @author jiashan
 *
 */
public class MaximumProductSubarray {

	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int result = nums[0];  // can not set to 0, since i = 1 will skip loop
		int[] min = new int[nums.length];
		int[] max = new int[nums.length];
		min[0] = max[0] = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			max[i] = Math.max(nums[i], Math.max(min[i - 1] * nums[i], max[i - 1] * nums[i]));
			min[i] = Math.min(nums[i], Math.min(min[i - 1] * nums[i], max[i - 1] * nums[i]));
			
			result = Math.max(result, max[i]);
		}
		
		return result;
    }
	
	
	public int maxProductOptmizeSpace(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int result = nums[0];  // can not set to 0, since i = 1 will skip loop
		int min = nums[0];
		int max = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			// as we only have 2 vars here. Need to use temp var, otherwise the following two formula will get influenced.
			int tempMax = max;
		    int tempMin = min;
		    
		    // sequence doesn't matter
			max = Math.max(nums[i], Math.max(tempMin * nums[i], tempMax * nums[i]));
			min = Math.min(nums[i], Math.min(tempMin * nums[i], tempMax * nums[i]));
			
			result = Math.max(result, max);
		}
		
		return result;
    }
	
}
