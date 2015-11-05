package com.diorsding.advance.twopointer;

import org.junit.Test;

/**
 * http://www.lintcode.com/en/problem/minimum-size-subarray-sum/
 * Given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.
 * 
 * Challenge: 
 * 1.If you have figured out the O(n) solution, 
 * 2.try coding another solution of which the time complexity is O(n log n).
 * 
 * Take care: 
 * 1.Positive Number
 * 2. condition is sum >= s
 * 
 * Follow up. 
 * 1. only cosider sum == s. 
 * 2. Negative Number included
 * 
 * @author jiashan
 *
 */
public class MinimumSizeSubArraySum {

	public int minimumSize(int[] nums, int s) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		
		int leftBound = 0; 
		int i = 0;
		int sum = 0;
		int length = Integer.MAX_VALUE;
		
		while (i < nums.length) {
			sum += nums[i];
			
			while (sum >= s) {
				length = Math.min(length, i - leftBound + 1);
				sum -= nums[leftBound];
				leftBound++;
			}
			
			i++;
		}
		
		return length == Integer.MAX_VALUE ? -1 : length;
    }
	
	@Test
	public void test() {
		int[] nums = {2,3,1,2,4,3};
		System.out.println(minimumSize(nums, 7));
	}
}
