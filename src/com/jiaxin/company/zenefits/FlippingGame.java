package com.jiaxin.company.zenefits;

import org.junit.Test;

/**
 * 
 * Give a array of 0 and 1s, you can flip one sub range of the array,
 * determine the maximal value of array after the flip. e.g given [0, 0, 0],
 * the best range to flip is 0~2 and maximal value would be 3
 * [0, 1, 0], you can flip the first one, or the last one, or all the three(but
 * can't just flip the first and last one as the range has to be continuous),
 * and the maximal value would be 2
 * 
 * 
 * @author jiashan
 *
 */
public class FlippingGame {

	
	public int flip(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		int oneCount = 0;
		for (int number : A) {
			if (number == 1) oneCount++; 
		}
		
		int temp = 0;
		int result = 0;
		for (int number : A) {
			if (number == 0) {
				temp ++; 
			} else {
				temp--;
			}
			
			temp = Math.max(0, temp);
			result = Math.max(result, temp);
		}
		
		return oneCount + result;
	}
	
	@Test
	public void test() {
		int[] A = {0,1,0};
		System.out.println(flip(A));
		
		int[] B = {0,0,0};
		System.out.println(flip(B));
		
		int[] C = {0,1,0,1,1,0,0,1};
		System.out.println(flip(C));
		
		int[] D = {1,0,0,1,0};
		System.out.println(flip(D));
		
		int[] E = {1,0,0,1};
		System.out.println(flip(E));
	}
}
