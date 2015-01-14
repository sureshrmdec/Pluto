package com.jiaxin.lc.newProblem;

/*
 * Need to record the minProduct 
 * 
 * Reference: http://yucoding.blogspot.com/2014/10/leetcode-quesion-maximum-product.html
 */
public class MaximumProductSubarray {
	// For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
	// case: [-2,0] [-3,-4] [-2] [0, 2] [3,-1,4] [-2,3,-4]
	public static int maxProduct(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
	
		int max = A[0];
		int maxProduct = A[0];
		int minProdcut = A[0];
		
		for (int i = 1; i < A.length; i++) {
			int tempMax = maxProduct;
			int tempMin = minProdcut;
			
			maxProduct = Math.max(Math.max(tempMax * A[i], tempMin * A[i]), A[i]);
			minProdcut = Math.min(Math.min(tempMax * A[i], tempMin * A[i]), A[i]);
			
			System.out.println("i: " + i + " maxProduct: " + maxProduct + " minProduct: " + minProdcut);
			
			max = Math.max(max, maxProduct);
		}
		
		return max;
    }
	
	public static void main(String[] args) {
		int[] A = {-2, 3, -4};
		
		System.out.println(maxProduct(A));
	}
	
}
