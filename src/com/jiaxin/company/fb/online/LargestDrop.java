package com.jiaxin.company.fb.online;

import org.junit.Test;

/**
 * Find the largest drop (not necessarily adjacent) in an array of integers
 * [1 20 17 19 2 25 10 16]
 * 
 * @author jiashan
 *
 */
public class LargestDrop {
	// buy stock I -- largest drop
	public int largestDrop(int[] A) {
		if (A == null || A.length == 0) {
			return 0; 
		}
		
		int max = Integer.MIN_VALUE;
		int drop = 0;
		
		for (int i = 0; i < A.length; i++) {
			max = Math.max(max, A[i]);
			
			drop = Math.max(drop, max - A[i]);
		}
		
		return drop;
	}
	
	@Test
	public void test() {
		int[] A = {1,20,17,19,2,25,10,16};
		
		System.out.println(largestDrop(A));
	}
}
