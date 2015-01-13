package com.jiaxin.lc.newProblem;

public class FindPeakElement {
	
	// test case: [3,2,1] [2,1]
	public static int findPeakElement(int[] num) {
		if (num == null || num.length == 0) {
			return -1;
		}
		
		if (num.length == 1) {
			return 0;
		}
		
		if (num.length == 2) {
			return num[0] > num[1] ? 0 : 1;
		}
	
		 
		int start = 0;
		int end = num.length - 1;
		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			
			if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {
				return mid;
			}
			
			if (num[mid] < num[mid - 1]) {
				end = mid;
			} else if (num[mid] < num[mid + 1]){
				start = mid;
			}
		}
				
		
		if (start - 1 >= 0 && start + 1 < num.length && num[start] > num[start - 1] && num[start] > num[start + 1]) {
			return start;
		}

		if (end - 1 >= 0 && end - 1 < num.length && num[end] > num[end - 1] && num[end] > num[end] + 1) {
			return end;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] num = {1};
		
		System.out.println(findPeakElement(num));
	}
}
