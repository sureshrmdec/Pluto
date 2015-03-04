package com.jiaxin.lc.dp.sequence;

/**
 * step[0] = 0; not 1. 
 * 
 * Don't need to calculate all value of j. first j will be the best, use most less steps
 * 
 * This one is a little different from JumpGame. must start from 0 to find least 
 * 
 * @author jiashan
 *
 */
public class JumpGameII {
	public int jump(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		int[] step = new int[A.length];
		step[0] = 0;
		
		for (int i = 0; i < A.length; i++) {
			step[i] = Integer.MAX_VALUE;  // add this line -> Time limit
			for (int j = 0; j < i; j++) {
				if (step[i] != Integer.MAX_VALUE && j + A[j] >= A[i]) {
					step[i] = step[j] + 1;
					break;
				}
			}
		}
	
		return step[A.length - 1];
	}
}
