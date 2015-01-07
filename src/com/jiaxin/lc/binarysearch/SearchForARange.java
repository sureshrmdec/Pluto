package com.jiaxin.lc.binarysearch;

public class SearchForARange {
	public int[] searchRange(int[] A, int target) {
		int[] result = new int[2]; 
		if (A == null || A.length == 0) {
			result[0] = result[1] = -1;
			return result;
		}
		
		int start = 0;
		int end = A.length - 1;
		int mid; 
		
		// left bound
		while (start + 1 < end) {
			mid = start + (end - start) / 2; 
			if (A[mid] >= target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		
		if (A[start] == target) {
			result[0] = start;
		} else if (A[end] == target) {
			result[0] = end;
		} else {
			result[0] = result[1] = -1;
			return result;
		}
		
		// right bound
		start = 0; 
		end = A.length - 1;
		while(start + 1 < end) {
			mid = start + (end - start) / 2;
			if (A[mid] <= target) {
				start = mid;
			} else {
				end = mid;
			} 
		}
		
		
		// check end first 
		if (A[end] == target) {
			result[1] = end;
		} else if (A[start] == target) {
			result[1] = start;
		}
		
		return result;
	}
}
