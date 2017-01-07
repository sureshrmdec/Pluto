package com.jiaxin.lc.twopointer3;

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		int index = m + n;
		
		while (m > 0 && n > 0) {
			if (A[m - 1] > A[n - 1]) {
				A[--index] = A[--m];
			} else {
				A[--index] = B[--n];
			}
		}
		
		while (n > 0) {
			A[--index] = B[--n];
		}
    }
}
