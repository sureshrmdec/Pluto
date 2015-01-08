package com.jiaxin.cc.Hard;

/**
 * 18.6 Describe an algorithm to find the smallest one million numbers in one billion numbers.
 * Assume that the computer memory can hold all on billion numbers. 
 *   
 * Solution1: 
 * 1. Sorting O(nlogn)
 * 2. maxHeap O(nlogm) m is the heap size
 * 3. quick sort O(n) 这里用这个
 * 
 * @author jeffwan
 * @date May 24, 2014
 */
public class SmallestOneM {
	public int[] find(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		
		int[] result = new int[k]; 
		findSmallestMHelper(nums, 0, nums.length, k);
		for (int i = 0; i < result.length; i++) {
			result[i] = nums[i];
		}
		
		return result;	
	}
	
	public int findSmallestMHelper(int[] nums, int start, int end, int k) {
		int pivot = start; 
		int left = start; 
		int right = end;
		
		while (start < end) {
			while (start < end && nums[left] <= nums[pivot]) {
				left++;
			}
			
			while (start < end && nums[right] >= nums[pivot]) {
				right--;
			}
			
			if (left < right) {
				swap(nums, left, right);
			}
		}
		
		swap(nums, pivot, right);
		
		if (k == right + 1) {
			return nums[right];
		} else if (k < right + 1) {
			return findSmallestMHelper(nums, start, right - 1, k);
		} else {
			return findSmallestMHelper(nums, right + 1, end, k);
		}
	}

	private void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
}
