package com.jiaxin.lc.newProblem;

import java.util.Arrays;

import org.junit.Test;

/*
 * [3,6,9,1] --> 3
 * [100,3,2,1] --> 97  
 * 
 * 
 * Reference: http://cgm.cs.mcgill.ca/~godfried/teaching/dm-reading-assignments/Maximum-Gap-Problem.pdf
 */
public class MaximumGap {
	public int maximumGap(int[] num) {
		if (num == null || num.length < 2) {
			return 0;
		}
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < num.length; i++) {
			max = Math.max(max, num[i]);
			min = Math.min(min, num[i]);
		}
		
		int[] minNums = new int[num.length - 1];
		int[] maxNums = new int[num.length - 1];
		Arrays.fill(minNums, Integer.MAX_VALUE);
		Arrays.fill(maxNums, Integer.MIN_VALUE);
		
		int gap = (int)Math.ceil((double)(max - min) / (num.length - 1));
		for (int value : num) {
			if (value != min && value != max) {
				int i = (value - min) / gap;
				minNums[i] = Math.min(minNums[i], value);
				maxNums[i] = Math.max(maxNums[i], value);
			}
		}
		
		// Scan the buckets for max gap
		int maxGap = Integer.MIN_VALUE;
		int preMax = min; // last non-empty bucket max value
		for (int i = 0; i < num.length - 1; i++) {
			if (minNums[i] != Integer.MAX_VALUE && maxNums[i] != Integer.MIN_VALUE) {
				maxGap = Math.max(maxGap, minNums[i] - preMax); // use min - preMax (successive)
				preMax = maxNums[i];
			}
		}
		
		maxGap = Math.max(maxGap, max - preMax); // last calculation 
		return maxGap;
    }
	
	
	@Test
	public void test() {
		int[] num = {100,3,2,1};
		
		System.out.println(maximumGap(num));
	}
}
