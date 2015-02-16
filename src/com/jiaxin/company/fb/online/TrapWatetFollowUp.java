package com.jiaxin.company.fb.online;

import org.junit.Test;
/**
 * 
 * 0 mean lou shui. we need slightly changes
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
			if (max < A[i]) {
				max = A[i];
			}
//			if (A[i] == 0) {
//				max = 0;
//			}
		}
		
		max = A[A.length - 1];
		maxRight[A.length - 1] = 0;
		for (int i = A.length - 1; i > 0; i--) {
			maxRight[i] = max;
			if (max < A[i]) {
				max = A[i];
			}
//			if (A[i] == 0) {
//				max = 0;
//			}
			
			if (Math.min(maxLeft[i], maxRight[i]) > A[i]) {
				
				int unitWater = Math.min(maxLeft[i], maxRight[i]) - A[i];;
//				if (A[i] == 0 || maxLeft[i] == Integer.MIN_VALUE || maxRight[i] == Integer.MIN_VALUE) {
//					unitWater = 0;
//				}
				
				sum += unitWater;
			}
		}
		
		return sum;
    }
	
	@Test
	public void test() {
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(A));
	}
}
