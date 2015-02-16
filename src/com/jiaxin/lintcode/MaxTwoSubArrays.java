package com.jiaxin.lintcode;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class MaxTwoSubArrays {
	// sum[i] = nums[0] + nums[1] .. nums[i];
	// subarray(i, j) = sum[j] - sum[i - 1];
    public int maxSubArray(ArrayList<Integer> nums) {
		if (nums == null || nums.size() == 0) {
			return 0;
		}
    	
		int sum = 0;
		int minSum = 0;
		int maxSum = Integer.MIN_VALUE;
		
		for (int i = 0; i < nums.size(); i++) {
			sum += nums.get(i);
			maxSum = Math.max(maxSum, sum - minSum);
			minSum = Math.min(minSum, sum);
		}
		
    	return maxSum;
    }
	
	// Find a seperator that left subarry + right subarray has maxSum
    // Same a stock III. -> maxSubarray 1.
	public int maxTwoSubArrays(ArrayList<Integer> nums) {
		if (nums == null || nums.size() == 0) {
			return 0;
		}
		
		int[] left = new int[nums.size() + 1];
		int[] right = new int[nums.size() + 1];
		
		left[0] = 0;
		int sum = 0;
		int minSum = 0;
		for (int i = 1; i < left.length; i++) {
			sum += nums.get(i - 1);
			left[i] = Math.max(left[i - 1], sum - minSum);
			minSum = Math.min(minSum, sum);
		}
		
		right[right.length - 1] = 0;
		sum = 0;
		minSum = 0;
		for (int i = right.length - 2; i >= 0; i--) {
			sum += nums.get(i - 1);
			right[i] = Math.max(right[i + 1], sum - minSum);
			minSum = Math.min(minSum, sum);
		}
		
		minSum = 0;
		for (int i = 0; i < nums.size() + 1; i++) {
			minSum = Math.max(minSum, left[i] + right[i]);
		}
		
		return minSum;
	}
	
	
	/**
	 *  maxThreeSubArrays
	 *  state: f[i][j]  first i, get j subarray -> maxSum
	 *  function: f[i][j] = Max { f[x][j - 1] + maxSubarray(x + 1, i);   j <= x <= i - 1 }
	 *  result: f[n][k]
	 *  initialize: f[i][0] = 0; f[0][i, i>0] = -8. 
	 *  
	 * @param nums
	 * @param k
	 * @return
	 */
	public int maxSubArray(ArrayList<Integer> nums, int k) {
		int[][] f = new int[nums.size() + 1][k + 1];
		
		// Initialization
		for (int i = 0; i < f.length; i++) {
			f[i][0] = 0;
		}
		
		for (int i = 1; i < k; i++) {
			f[0][i] = Integer.MIN_VALUE;
		}
		
		for (int i = 1; i <= f.length; i++) {
			for (int j = 1; j <= f[0].length; j++) {
				
				for (int x = j; x <= i - 1; x++) {
					f[i][j] = Math.max(f[i][j], maxSub(nums, x + 1, i));
				}
			}
		}
		
		
		return f[nums.size()][k];
    }
	
	private int maxSub(ArrayList<Integer> nums, int i, int j) {
		if (nums == null || nums.size() == 0) {
			return 0;
		}
    	
		int sum = 0;
		int minSum = 0;
		int maxSum = Integer.MIN_VALUE;
		
		for (int x = i - 1; x < j; x++) {
			sum += nums.get(x);
			maxSum = Math.max(maxSum, sum - minSum);
			minSum = Math.min(minSum, sum);
		}
		
		return maxSum;
	}

	@Test
	public void test() {
		Integer[] numbers = {1, 3, -1, 2, -1, 2};
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(1); nums.add(3); nums.add(-1); nums.add(2); nums.add(-1); nums.add(2);
//		System.out.println(maxTwoSubArrays(nums));
		
		System.out.println(maxSub(nums, 0,5));
		System.out.println(maxSubArray(nums, 2));
	}
	
}
