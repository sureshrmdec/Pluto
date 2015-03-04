package com.jiaxin.lc.dp.sequence;
/**
 * j in range (i-1 ... 0) will be more effient that (0..j-1). 
 * remember to break;
 * 
 * @author jiashan
 *
 */
public class JumpGameI {
	public boolean canJump(int[] A) {
		if (A == null || A.length == 0) {
			return false;
		}
	
		boolean[] can = new boolean[A.length];
		can[0] = true;
		
		for (int i = 1; i < A.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (can[j] && j + A[j] >= i) {
					can[i] = true;
					break;
				}
			}
		}
		
		return can[A.length - 1];
	}
}
