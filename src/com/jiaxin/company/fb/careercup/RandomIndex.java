package com.jiaxin.company.fb.careercup;

import org.junit.Test;

/**
 * [1,2,-4,5,1,-6,-3,5,5,2,3] return max index, if there's multiple max, return random one. 
 * O(n) + O(1) space use random to find 
 * 
 * 1. Iterate and find biggest
 * 2. second pass find random.
 * 
 * One pass is good enough
 * 
 * http://www.guokr.com/blog/745588/
 * @author jiashan
 *
 */
public class RandomIndex {
	
	// One Pass. Good enough
	public int randomMaxIndex(int[] A) {
		int max = Integer.MIN_VALUE;
		int count = 0;
		int candidate = 0; // index of maximum
		
		for (int i = 0; i < A.length; i++) {
			if (max < A[i]) {
				max = A[i];
				count = 1;
				candidate = i;
			}
			
			if (max == A[i]) {
				count++;
				
				double prob = Math.random();
				if (prob < (double) 1 / count) {
					candidate = i;
				}
			}
		}
		
		return candidate;
	}
	
	
	public int randomMaxIndexTwoPass(int[] A) {
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < A.length; i++) {
			max = Math.max(max, A[i]);
		}
		
		int count = 0;
		int candidate = Integer.MAX_VALUE;
		
		for (int i = 0; i < A.length; i++) {
			if (A[i] == max) {
				count++;
				if (candidate == Integer.MAX_VALUE) {
					candidate = i;
				}
				
				double prob = Math.random();
				if (prob < (double) 1 / count) {
					candidate = i;
				}
			}
		}
		
		return candidate;
	}
	
	
	@Test
	public void test() {
		int[] A = {1,2,-4,5,1,-6,-3,5,5,2,3};
		
		System.out.println(randomMaxIndex(A));
	}
}
