package com.jiaxin.cc.RecursiveAndDP;
/**
 *  -10 -5 2 2 2 3 4 5 9
 *  0    1 2 3 4 5 6 7 8
 *  拿 index = 5 举例就知道啦
 * @author jeffwan
 * @date May 18, 2014
 */

public class MagicNumber {
	
	// Magic Number duplicates的情况
	public int magicNumber(int[] nums) {
		return magicNumber(nums, 0, nums.length - 1);
	}

	private int magicNumber(int[] nums, int start, int end) {
		if (end < start || start < 0 || end >= nums.length) {
			return -1;
		}
		
		int midIndex = (start + end) / 2;
		int midValue = nums[midIndex];
		if (midValue == midIndex) {
			return midIndex;
		}
		
		// search left
		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = magicNumber(nums, start, leftIndex);
		if (left != -1) {
			return left;
		}
		
		// search right
		int rightIndex = Math.min(midIndex + 1, midValue);
		int right = magicNumber(nums, rightIndex, end);
		if (right != -1) {
			return right;
		}
		
		return -1;
	}
}
