package com.diorsding.advance.followup;

import java.util.List;

/**
 * http://www.lintcode.com/en/problem/find-peak-element/
 * 
 * http://www.lintcode.com/en/problem/find-peak-element-ii/
 * peak number > four direction. 
 * O(nlogm) or O(mlogn) -> O(m + n) 
 *
 * 
 * @author jiashan
 *
 */
public class FindPeakElement {

	public int findPeak(int[] A) {
		if (A == null || A.length == 0) {
			return -1;
		}
		
		int start = 0;
		int end = A.length - 1;
		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
				return mid;
			}
			
			if (A[mid] > A[mid - 1]) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		if (A[start] > A[end]) {
			return start;
		} else {
			return end;
		}
	}
	
	
	
	
	public List<Integer> findPeakII(int[][] A) {
		
		
		return null;
	}
	
}
