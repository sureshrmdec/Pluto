package com.jiaxin.lc.twopointer2;

public class RemoveElement {
	//Test case: [2], 3
	// Difference between this and RemoveDuplicateArray is that one, first digit will definately copyed. this one doesn't, ArrayOutofIndex. 
	public int removeElement(int[] A, int elem) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		int size = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != elem) {
				A[size++] = A[i];
			}
		}
		
		return size;
	}
}
