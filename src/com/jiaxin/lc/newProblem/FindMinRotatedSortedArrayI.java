package com.jiaxin.lc.newProblem;

// Reference: http://blog.csdn.net/linhuanmars/article/details/40449295
public class FindMinRotatedSortedArrayI {
/*
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Find the minimum element.
 */
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
    		} else {
    			min = Math.min(min, num[end]);
    			end = mid;
    		}
    	}
		
    	min = Math.min(min, num[start]);
    	min = Math.min(min, num[end]);
    	
    	return min;
    }
    
    public static void main(String[] args) {
    	int[] num = {4,5,6,7,0,1,2};
    	System.out.println(findMin(num));
    }
}
