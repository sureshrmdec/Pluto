package com.jiaxin.lc.binarysearch;

public class SearchRotatedSortedArrayII {
	// we can't use A[start] < A[mid] or A[start] > A[mid] to justify continious interval. use == 
 	
	public boolean search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return false;
		}
		
		int start = 0;
		int end = A.length - 1;
		int mid;
		
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			
			if (target == A[mid]) {
				return true;
			}
			
			if (A[start] < A[mid]) {
				if (target >= A[start] && target < A[mid]) {
					end = mid;
				} else {
					start = mid;
				}
			} else if (A[start] > A[mid]) {
				if (target <= A[end] && target > A[mid]) {
					start = mid;
				} else {
					end = mid;
				}
			} else {
				start++;
			}
		} 
		
		if (target == A[start]) {
			return true;
		}
		
		if (target == A[end]) {
			return true;
		}
		
		return false;
	}
	
}
