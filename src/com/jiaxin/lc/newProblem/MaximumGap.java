package com.jiaxin.lc.newProblem;

/*
 * [3,6,9,1] --> 3
 * [100,3,2,1] --> 97  
 */
public class MaximumGap {
	public static int maximumGap(int[] num) {
		if (num == null || num.length < 2) {
			return 0;
		}
		
		int max = num[0];
		
		for (int i = 1; i < num.length - 1; i++) {
			if ((num[i] > num[i - 1] && num[i] < num[i + 1]) || (num[i] < num[i - 1] && num[i] > num[i + 1])) {
				Math.max(Math.abs(num[i] - num[i - 1]), Math.abs(num[i] - num[i + 1]));
			}
		}
		
		return max;
    }
	
	public static void main(String[] args) {
		int[] num = {100,3,2,1};
		
		System.out.println(maximumGap(num));
	}
}
