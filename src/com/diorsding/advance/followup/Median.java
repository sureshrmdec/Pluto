package com.diorsding.advance.followup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * http://www.lintcode.com/en/problem/median/
 * Solution: use same solution in quick select. kth = length / 2
 *
 * 1. One unsorted Array  --> median
 * 2. Two sorted Array    --> median of two sorted array
 * 
 * http://www.lintcode.com/en/problem/median-of-two-sorted-arrays/
 * Solution: throws half
 * 
 * http://www.lintcode.com/en/problem/data-stream-median/
 * 
 * 
 * http://www.lintcode.com/en/problem/sliding-window-median/
 * 
 * @author jiashan
 *
 */
public class Median {
	
	// Median 
	public int median(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int start = 0;
		int end = nums.length - 1;
		
		if (nums.length % 2 == 0) {
			return findKth(nums, start, end, nums.length / 2);
		} else {
			return findKth(nums, start, end, nums.length / 2 + 1);
		}
	}

	private int findKth(int[] nums, int start, int end, int k) {
		int pivot = start;
		int left = start;
		int right = end;
		
		while (left <= right) {
			while (left <= right && nums[left] <= nums[pivot]) {
				left++;
			}
			
			while (left <= right && nums[right] >= nums[pivot]) {
				right--;
			}
		}
		
		if (k == right + 1) {
			return nums[right];
		} else if (k > right + 1) {
			return findKth(nums, right + 1, end, k);
		} else {
			return findKth(nums, start, right - 1, k);
		}
	}
	
	
	// Median of Two sorted array
	public double findMedianSortedArrays(int[] A, int[] B) {
		if (A == null || B == null || A.length == 0 || B.length == 0) {
			return 0;
		}
		
		int length = A.length + B.length;
		
		if (length % 2 == 1) {
			return findKth(A, B, 0, 0, length / 2 + 1);
		} else {
			return (findKth(A, B, 0, 0, length / 2 + 1) + findKth(A, B, 0, 0, length / 2)) / 2;
		}
			
    }
	
	private double findKth(int[] A, int[] B, int AStart, int BStart, int k) {
		if (AStart == A.length) {
			return B[BStart + k - 1];
		}
		
		if (BStart == B.length) {
			return A[AStart + k - 1];
		}
		
		if (k == 1) {
			return Math.min(A[AStart], B[BStart]);
		}
		
		int AKey = AStart + k/2 - 1 < A.length ? A[AStart + k/2 - 1] : Integer.MAX_VALUE;
		int BKey = BStart + k/2 - 1 < B.length ? B[BStart + k/2 - 1] : Integer.MAX_VALUE;
		
		if (AKey < BKey) {
			return findKth(A, B, AStart + k/2, BStart, k - k/2);
		} else {
			return findKth(A, B, AStart, BStart + k/2, k - k/2);
		}
	}

	// Data Stream Median -- maxHeap.size = (minHeap.size, minHeap.size + 1)
	public int[] medianII(int[] nums) {
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(nums.length);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		int[] result = new int[nums.length];
		
		for (int i = 0; i < nums.length; i++) {
			int number = nums[i];
			
			if (maxHeap.size() == minHeap.size()) {
				if (minHeap.peek() != null && number > minHeap.peek()) {
					maxHeap.offer(minHeap.poll());
					minHeap.offer(number);
				} else {
					maxHeap.offer(number);
				}
			} else {
				if (number < maxHeap.peek()) {
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(number);
				} else {
					minHeap.offer(number);
				}
			}
			
			result[i] = maxHeap.peek();
		}
		
		return result;
    }
	
	@Test
	public void test() {
		int[] nums = {1,2,3,4,5};
		int[] result = medianII(nums);
		for (int num : result) {
			System.out.print(num);
		}
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(nums.length);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		maxHeap.add(1);
		maxHeap.add(2);
		System.out.print(maxHeap.peek());
		maxHeap.add(3);
		System.out.print(maxHeap.peek());
	}
	
	/*
	if (maxHeap.size() == minHeap.size()) {
		
		if (number > minHeap.peek()) {
			result[i] = minHeap.peek();
			minHeap.offer(number);
		}
		
		if (number < maxHeap.peek()) {
			result[i] = maxHeap.peek();
			minHeap.offer(maxHeap.poll());
		}
		
		if (number < minHeap.peek() && number > maxHeap.peek()) {
			result[i] = number;
			minHeap.offer(number);
		}

	} else {
		if (number > minHeap.peek()) {
			result[i] = minHeap.peek();
			maxHeap.offer(minHeap.poll());
		}
		
		if (number < maxHeap.peek()) {
			result[i] = maxHeap.peek();
			maxHeap.offer(number);
		}
		
		if (number < minHeap.peek() && number > maxHeap.peek()) {
			result[i] = number;
			maxHeap.offer(number);
		}
	}*/
	
	
	public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (nums.length < k) {
			return result;
		}
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(nums.length);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		for (int i = 0 ; i < nums.length - k + 1; i++) {
			
		}
		
		
		return null;
    }
	
	
}
