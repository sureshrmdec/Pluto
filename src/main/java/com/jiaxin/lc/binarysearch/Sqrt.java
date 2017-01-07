package com.jiaxin.lc.binarysearch;

public class Sqrt {
	// Test case: 2, 6. end = x/2 is good, no need plus 1.
	
	public int sqrt(int x) {
		if (x <= 0) {
			return x;
		}
		
		int start = 1;
		int end = x / 2;
		int mid; 
		
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			
			if (x / mid == mid) {
				return mid;
			} else if (x / mid < mid) {
				end = mid;
			} else {
				start = mid;
			}
		}
		
		if (x / start == start) {
			return start;
		}
		
		if (x / end == end) {
			return end;
		}
		
		return start;
	}
}
