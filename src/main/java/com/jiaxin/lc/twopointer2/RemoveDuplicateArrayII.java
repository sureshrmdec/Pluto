package com.jiaxin.lc.twopointer2;

public class RemoveDuplicateArrayII {
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		int size = 0;
		
		for (int i = 0; i < A.length; i++) {
			if (A[size] == A[i] && size != 0 && A[size] == A[size - 1]) {
				continue;
			}
			
			A[++size] = A[i];
		}
		
		return size + 1;
    }
}
