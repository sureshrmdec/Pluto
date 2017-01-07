package com.jiaxin.lc.twopointer2;

public class RemoveDuplicateArray {
	// test case: [1]
	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		int size = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[size] != A[i]) {
				A[++size] = A[i];
			}
		}
		
		return size + 1;
	}
}
