package com.jiaxin.company.fb.careercup;
/**
 * Question:  Given a sequence of positive integers A and an integer T, 
 * return whether there is a continuous sequence of A that sums up to exactly T
 * 
 * Example: 
 * [23, 5, 4, 7, 2, 11], 20. Return True because 7 + 2 + 11 = 20 
 * [1, 3, 5, 23, 2], 8. Return True  because 3 + 5 = 8
 * [1, 3, 5, 23, 2], 7 Return False because no sequence in this array adds up to 7
 * 
 * Use Sliding Window to slides along the sequence, watching the sum of numbers inside the window: 
 * If sum less than T: expand the window to the right; 
 * If sum = T: report true, finish; 
 * If sum > T: shrink the window from left
 * 
 * @author jiashan
 *
 */
public class ContinuousSumToTarget {
	public boolean findSum (int [] A ,int T){
		return false;
	}
}
