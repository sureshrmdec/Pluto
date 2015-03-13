package com.jiaxin.lc.newProblem;

import org.junit.Test;


/**
 * 1. rotate arrays. 5 6 7 1 2 3 4 -> 1 2 3 4 5 6 7. 
 * reverse left part, reverse right part. and reverse all.
 * 
 * 2. Leetcode give K ask rotate. 
 * 
 * A Few solutions
 * 
 * @author jiashan
 *
 */
public class RotateArray {
	public void rotate(int[] nums, int k) {

	}
	
	
	
	@Test
	public void test() {
		int[] nums = {1,2,3};
		rotate(nums, 1);
		
		for (int num :  nums) {
			System.out.print(num + ",");
		}
	}
}
