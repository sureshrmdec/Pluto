package com.diorsding.advance.datastructure;

/**
 * http://www.lintcode.com/en/problem/heapify/
 * or a heap array A, A[0] is the root of heap, and for each A[i], 
 * A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
 * 
 * Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.
 * 
 * @author jiashan
 *
 */
public class Heapify {

	public void heapify(int[] A) {
		for (int i = A.length / 2; i >= 0; i--) {
			shiftDown(A, i);
		}
    }

	private void shiftDown(int[] A, int k) {
		while (k < A.length) {
			int smallest = k;
			if (k * 2 + 1 < A.length && A[k * 2 + 1] < A[smallest]) {
				smallest = k * 2 + 1;
			}
			
			if (k * 2 + 2 < A.length && A[k * 2 + 2] < A[smallest]) {
				smallest = k * 2 + 2;
			}
			
			if (k == smallest) {
				break;
			}
			
			int temp = A[smallest];
			A[smallest] = A[k];
			A[k] = temp;
			
			k = smallest;
		}
	}
}
