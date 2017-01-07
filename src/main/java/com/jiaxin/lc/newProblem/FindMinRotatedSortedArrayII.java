package com.jiaxin.lc.newProblem;

public class FindMinRotatedSortedArrayII {
	public static int findMin(int[] num) {
		if (num == null || num.length == 0) {
			return Integer.MAX_VALUE;
		}
		
		int min = Integer.MAX_VALUE;
		int start = 0;
		int end = num.length - 1;
		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2; 
			if (num[mid] > num[start]) {
				min = Math.min(min, num[start]);
				start = mid;
			} else if (num[mid] < num[start]){
				min = Math.min(min, num[end]);
				end = mid;
			} else {
				min = Math.min(min, num[start]);
				start++;
			}
		}
		
		min = Math.min(min, num[start]);
		min = Math.min(min, num[end]);
		
		return min;
    }
	
	public static void main(String[] args) {
		int[] num = {5,5,6,7,7,1,2,3,4};
		System.out.println(findMin(num));
	}
}
