package com.jiaxin.lc.dp.sequence;

public class JumpGameII {
	// Don't need to calculate all value of j. first j will be the best
	public int jump(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		int[] step = new int[A.length];
		step[0] = 0;
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < i; j++) {
				if (j + A[j] >= A[i]) {
					step[i] = step[j] + 1;
					break;
				}
			}
		}
	
		return step[A.length - 1];
	}
}
