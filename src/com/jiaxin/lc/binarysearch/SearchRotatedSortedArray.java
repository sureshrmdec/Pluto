package com.jiaxin.lc.binarysearch;

public class SearchRotatedSortedArray {
	public int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}
		
		int start = 0;
		int end = A.length - 1;
		int mid;
		
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			
			if (target == A[mid]) {
				return mid;
			}
			
			if (A[start] < A[mid]) {
				if (target >= A[start] && target < A[mid]) {
					end = mid;
				} else {
					start = mid;
				}
			} else if (A[start] > A[mid]) {
				if (target > A[mid] && target <= A[end]) {
					start = mid;
				} else {
					end = mid;
				}
			}
		}
		
		if (A[start] == target) {
			return start;
		}
		
		if (A[end] == target) {
			return end;
		}
 		
		return -1;
	}
}
