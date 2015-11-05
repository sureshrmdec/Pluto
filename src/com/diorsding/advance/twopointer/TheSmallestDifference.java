package com.diorsding.advance.twopointer;

import java.util.Arrays;

/**
 * http://www.lintcode.com/en/problem/the-smallest-difference/
 * 
 * For example, given array A = [3,6,7,4], B = [2,8,9,3], return 0
 * Challenge: O(n log n) time
 * 
 * Naive: compare with each other. O(n^2).
 * 
 * Solution 1: Sorted two array. nlog(n). start from head, move smaller one. 
 * 
 * Solution 2: Binary Search. insert position. compare with left & right
 * 
 * Solution 3: Just Merge to one big array. compare neibourhouds, Need define structure  
 * 
 * 
 * @author jiashan
 *
 */
public class TheSmallestDifference {
	
	// Solution 1. 
	public int smallestDifference(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		
		int i = 0;
		int j = 0;
		int smallest = Integer.MAX_VALUE;
		
		while (i < A.length && j < B.length) {
			smallest = Math.min(smallest, Math.abs(A[i] - B[j]));
			
			if (A[i] == B[j]) {
				return 0;
			}
			
			if (A[i] < B[j]) {
				i++;
			} else {
				j++;
			}
		}
		
		return smallest;
    }
}
