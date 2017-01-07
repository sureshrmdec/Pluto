package com.jiaxin.company.fb.online;

import org.junit.Test;

/**
 * 
 * Loop for all elements in arr[] and maintain two sums incl and excl 
 * where incl = Max sum including the previous element and excl = Max sum excluding the previous element.
 * Max sum excluding the current element will be max(incl, excl) and
 * max sum including the current element will be excl + current element (Note that only excl is considered 
 * because elements cannot be adjacent).
 * 
 * At the end of the loop return max of incl and excl.
 * 
 * include = exclude + A[i];  -> means exlucde the last element. A[i - 1]
 * exclude = Math.max(exclude, lastInclude);  lastInclude -> A[i - 1].
 * 
 * http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 * @author jiashan
 *
 */
public class MaximumSumNoAdjacent {
	public int maximumSum(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
			
		int include = A[0];
		int exclude = 0;
		System.out.println("exclude: " + exclude + " include: " + include);
		
		for (int i = 1; i < A.length; i++) {
			int lastInclude = include;
			include = exclude + A[i];
			exclude = Math.max(exclude, lastInclude);
			
			System.out.println("exclude: " + exclude + " include: " + include);
		}
		
		return Math.max(include, exclude);
	}
	
	@Test
	public void test() {
		int[] A = {5,  5, 10, 40, 50, 35};
		System.out.println(maximumSum(A));
	}
}
