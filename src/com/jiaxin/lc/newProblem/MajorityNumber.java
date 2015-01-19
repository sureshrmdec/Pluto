package com.jiaxin.lc.newProblem;

/*
 * O(1) space, O(n) one pass -- one candidate, one candidate occurance.
 *  
 * when we meet two numbers different, throw them together, same, count in. 
 * if count = 0, change candidate to next value.
 */

public class MajorityNumber {
	public int majorityElement(int[] num) {
		int candidate = num[0];
		int count = 1;
		
		for (int i = 0; i < num.length; i++) {
			if (count == 0) {
				candidate = num[i];
				count++;
			} else {
				if (candidate == num[i]) {
					count++;
				} else {
					count--;
				}
			}
		}
				
		return candidate;		
	}
}
