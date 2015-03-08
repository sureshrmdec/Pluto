package com.jiaxin.company.fb.online;

import java.util.HashMap;

import org.junit.Test;

/**
 * 
 * Solution: increase sum to target, and then move leftBound
 * 
 * detail:
 * start < i     could moved to only one element left. 
 * start < i - 1 must be strictly subarray
 * 
 * http://www.meetqun.com/forum.php?mod=viewthread&tid=6696&page=1#pid46416
 * 
 * ---------------------------------------------------------------------------
 * Find Longest Contiguous Subarray Sum to Zero, For example:
 * {1, 2 -3, 1, 5, -5, 6} should return {2, -3, 1, 5, -5}
 * We can also use hashing. The idea is to iterate through the array and for every element arr[i], 
 * calculate sum of elements form 0 to i (this can simply be done as sum += arr[i]). 
 * If the current sum has been seen before, then there is a zero sum array. 
 * Hashing is used to store the sum values, so that we can quickly store sum and find out whether the current sum is seen before or not.
 * 
 * 
 * http://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
 * 
 * @author jiashan
 *
 */
public class SubarraySumToTarget {
	// only works for 
	public boolean subarraySum(int[] A, int target) {
		if (A == null || A.length == 0) {
			return false;
		}
		
		int curSum = 0;
		int leftBound = 0;
		
		for (int i = 0; i < A.length; i++) {			
			// if exceeds target, remove head. 
			while (curSum > target && leftBound < i) {
				curSum -= A[leftBound];
				leftBound++;
			}
			
			if (curSum == target && i > leftBound) {
				return true;
			}
			
			if (curSum < target) {
				curSum += A[i];
			}
		}
		
		return curSum == target;
	}
	
	public boolean findTarget(int[] A, int target) {
		if (A == null || A.length == 0) {
			return false; 
		}
		
		int leftBound = 0;
		int sum = 0;
		
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			
			if (sum == target) {
				return true; 
			}
			
			while (leftBound < i && sum > target) {
				sum -= A[leftBound];
				leftBound++;
				
				if (sum == target && i > leftBound) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	//
	public boolean zeroSumSubarray(int[] A, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int sum = 0;
		
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			
			if (A[i] == 0 || sum == 0 || map.containsKey(Math.abs(target - sum))) {
				return true;
			}
			
			map.put(sum, i);
		}
		
		return false;
	}
	
	
	
	
	@Test
	public void test() {
		int[] A = {15, 2, 4, 8, 9, 5, 10, 23};
		int[] B = {4, 2, -3, 1, 6};
		
		int[] C = {1, 3, 7, 23};
		
		int[] D = {1, 2 -3, 1, 5, -5, 6};

		System.out.println(subarraySum(C, 0));
		System.out.println(findTarget(B, 3)); // don't support negative numbers
//		
//		System.out.println("----------------------");
//	
		System.out.println(zeroSumSubarray(D, 0));
		System.out.println(zeroSumSubarray(C, 3));
	}
}
