package com.jiaxin.lc.binarysearch;

/*
 * Overrall runtime complexity should be O(log(m + n)).
 * 
 * http://yucoding.blogspot.com/2013/01/leetcode-question-50-median-of-two.html
 */
public class MedianOfTwoSortedArray {
	public static double findMedianSortedArrays(int A[], int B[]) {
		int len = A.length + B.length;
		
		if (len % 2 == 1) {
			return findKth(A, 0, B, 0, len/2 + 1);
		} else {
			return (findKth(A, 0, B, 0, len/2)+ findKth(A, 0, B, 0, len/2 + 1)) / 2;
		}
	}

	private static double findKth(int[] A, int AStart, int[] B, int BStart, int k) {
		if (AStart >= A.length) {
			return B[BStart + k - 1];
		}
		
		if (BStart >= B.length) {
			return A[AStart + k - 1];
		}
		
		if (k == 1) {
			return Math.min(A[AStart], B[BStart]);
		}
		
		int AKey = AStart + k/2 - 1 < A.length ? A[AStart + k/2 - 1] : Integer.MAX_VALUE;  
		int BKey = BStart + k/2 - 1 < B.length ? B[BStart + k/2 - 1] : Integer.MAX_VALUE;
		
		if (AKey < BKey) {
			return findKth(A, AStart + k/2, B, BStart, k - k/2);
		} else {
			return findKth(A, AStart, B, BStart + k/2, k - k/2);
		}
	}



	/*
	 * [1,3,5,7,9]
	 * [2,4,8,10,12,14,16,18]
	 * 
	 * [1,2,3,4,5,7,8,9,10,12,14,16,18]
	 * 
	 * [1, 2]
	 * [2,3,4,5,6,7]
	 * 
	 */
	
	public static void main(String[] args) {
		int[] A = {};
		int[] B = {1,2,3};
		
		System.out.println(findMedianSortedArrays(A, B));
	}
	
}
