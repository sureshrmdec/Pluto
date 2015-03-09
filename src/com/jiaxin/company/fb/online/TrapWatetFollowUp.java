package com.jiaxin.company.fb.online;

import org.junit.Test;
/**
 * 
 * 1st Optimization O(n) time + O(1) space
 * 
 * Follow up: 
 * 0 mean lou shui. we need slightly changes
 * 
 * if there's 0, left most and right most becomes 0
 * 
 * Not calculated
 * 1. mostLeft or mostright == 0, 0 - A[i] < 0. will not calculated
 * 2. A[i] = 0. 
 * 
 * @author jiashan
 *
 */
public class TrapWatetFollowUp {
	public int trap(int[] A) {
        if (A == null || A.length == 0) {
			return 0;
		}
		
		int sum = 0;
		int[] maxLeft = new int[A.length];
		int[] maxRight = new int[A.length];
		
		int max = A[0];
		maxLeft[0] = 0;
		for (int i = 1; i < A.length - 1; i++) {
			maxLeft[i] = max;
			if (max < A[i] || A[i] == 0) {
				max = A[i];
			}
		}
		
		max = A[A.length - 1];
		maxRight[A.length - 1] = 0;
		for (int i = A.length - 1; i > 0; i--) {
			maxRight[i] = max;
			if (max < A[i] || A[i] == 0) {
				max = A[i];
			}
			
			// mostLeft == 0, 0 - A[i] < 0. will not calculated
			if (Math.min(maxLeft[i], maxRight[i]) > A[i] && A[i] != 0) {
				int unitWater = Math.min(maxLeft[i], maxRight[i]) - A[i];;
				sum += unitWater;
			}
		}
		
		return sum;
    }
	
	public int trapNoSpace(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		int maxLeft = A[0];
		int maxRight = A[A.length - 1];
		int result = 0;
		
		int left = 0;
		int right = A.length - 1; 
		
		while (left <= right) {
			if (maxLeft < maxRight) {
				result += Math.max(0, maxLeft - A[left]);
				maxLeft = Math.max(maxLeft, A[left]);
				left++;
			} else {
				result += Math.max(0, maxRight- A[right]);
				maxRight = Math.max(maxRight, A[right]);
				right--;
			}
		}
		
		return result;
	}
	
	
	
	@Test
	public void test() {
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(A));
		System.out.println(trapNoSpace(A));
	}
}
