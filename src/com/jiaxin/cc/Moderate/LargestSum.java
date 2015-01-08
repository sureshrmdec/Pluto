package com.jiaxin.cc.Moderate;

/**
 * 17.8 You are given an array of integers (both positive and nagative). Find the cotiguous sequence with the largest sum. 
 * Return the sum.
 * 
 * Solution: Sliding Window. 碰到sum = 0；就重新来.
 * 
 * @author jeffwan
 * @date May 24, 2014
 */
public class LargestSum {
	public static void main(String[] args) {
		int[] nums = {2, -8, 3, -2, 4, -10};
		System.out.println(largestSum(nums));
	}
	
	public static int largestSum(int[] nums) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			max = Math.max(max, sum);
			sum = Math.max(sum, 0);
		}
		
		return max;
	}
}
