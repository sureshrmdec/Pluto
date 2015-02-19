package com.jiaxin.company.fb.online;

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
 * @author jiashan
 *
 */
public class SubarraySumToTarget {
	public boolean subarraySum(int[] A, int target) {
		if (A == null || A.length == 0) {
			return false;
		}
		
		int curSum = 0;
		int start = 0;
		
		for (int i = 0; i < A.length; i++) {			
			// if exceeds target, remove head. 
			while (curSum > target && start < i) {
				curSum -= A[start];
				start++;
			}
			
			if (curSum == target) {
				return true;
			}
			
			if (curSum < target) {
				curSum += A[i];
			}
		}
		
		return false;
	}
	
	@Test
	public void test() {
		int[] A = {15, 2, 4, 8, 9, 5, 10, 23};
		
		System.out.println(subarraySum(A, 9));
	}
}
