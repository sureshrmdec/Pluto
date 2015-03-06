package com.jiaxin.company.fb.round2;

/*
 * Manager
 * 1. sqrt
 * 
 */
public class Ninth {
	// 1. sqrt - int 
	public int sqrt(int x) {
		if (x < 0) {
			throw new IllegalArgumentException("Can not be negative");
		}
		
		if (x == 0) {
			return 0;
		}
		
		int start = 1;
		int end = x / 2 + 1;
		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			
			if (mid == x / mid) {
				return mid;
			} else if (mid < x / mid) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		if (start == x / start) {
			return start;
		}
		
		if (end == x / end) {
			return end;
		}
		
		
		throw new IllegalArgumentException("Can found sqrt for " + x);
	}
	
}
