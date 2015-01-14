package com.jiaxin.lc.newProblem;

public class FindPeakElement {
	
	// test case: [3,2,1] [2,1]
	public static int findPeakElement(int[] num) {
		if (num == null || num.length == 0) {
			return -1;
		}
		
		int start = 0;
		int end = num.length - 1;
	
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			
			if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {
				return mid; 
			}
			
			if (num[mid] < num[start]) {
				end = mid;
			} else {
				start = mid;
			}
		}
		
		return num[start] > num[end] ? start :end;
	}
	
	public static void main(String[] args) {
		int[] num = {1,2};
		
		System.out.println(findPeakElement(num));
	}
}
