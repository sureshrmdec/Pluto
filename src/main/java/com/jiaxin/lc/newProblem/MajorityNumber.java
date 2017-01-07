package com.jiaxin.lc.newProblem;

import java.util.ArrayList;

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
	
	// majoritynumber II. more than 1/3
	public int majorityNumber(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
			throw new IllegalArgumentException();
		}

		int candidate1 = Integer.MAX_VALUE;
		int candidate2 = Integer.MAX_VALUE;
		int count1 = 0; 
		int count2 = 0;

		for (int number: nums) {
			if (candidate1 != Integer.MAX_VALUE && candidate1 == number) {
				count1++;
			} else if (candidate2 != Integer.MAX_VALUE && candidate2 == number) {
				count2++;
			} else if (count1 == 0) {
				candidate1 = number;
				count1++;
			} else if (count2 == 0) {
				candidate2 = number;
				count2++;
			} else {
				count1--;
				count2--;
			}
		}
		
		count1 = count2 = 0;
		for (int number : nums) {
			if (number == candidate1) {
				count1++;		
			}

			if (number == candidate2) {
				count2++;
			}
		}

		return count1 > count2 ? candidate1 : candidate2;
    }
	
}



