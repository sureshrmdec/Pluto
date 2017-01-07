package com.jiaxin.lc.newProblem;

/*
 * if num[mid] > num[start], the minValue is num[start], then we go right
 * same steps when num[mid] < num[start]
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Find the minimum element.
 * 
 *  Reference: http://blog.csdn.net/linhuanmars/article/details/40449295
 */
public class FindMinRotatedSortedArrayI {
	public int findMin(int[] num) {
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
    		} else {
    			min = Math.min(min, num[mid]);
    			end = mid;
    		}
    	}
		
    	min = Math.min(min, num[start]);
    	min = Math.min(min, num[end]);
    	
    	return min;
    }
}
