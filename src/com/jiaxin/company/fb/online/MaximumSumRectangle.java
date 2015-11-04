package com.jiaxin.company.fb.online;

import org.junit.Test;

public class MaximumSumRectangle {

	
	public int maxSubRec(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		int[][] colSum = matrix;
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				colSum[i][j] += colSum[i - 1][j];
			}
		}
		
		int result = 0;
		
		for (int i = 0; i < m; i++) {
			for (int k = 0; k <= i; k++) {
				int minSum = 0;
				int max = Integer.MIN_VALUE;
				int[] sum = new int[n];
				
				for (int j = 0; j < n; j++) {
					int col = (i == 0)? colSum[i][j] : colSum[i][j] - colSum[k][j];
					sum[j] = j == 0? col : col + sum[j - 1]; 
					result = Math.max(result, sum[j] - minSum);
					minSum = Math.min(minSum, sum[j]);
				}
				
				result = Math.max(result, max);
			}
		}
		
		return result;
	}
	
	@Test
	public void test() {
		int[][] matrix = {
				{1,2,-1,-4,-20},
				{-8,-3,4,2,1},
				{3,8,10,1,3},
				{-4,-1,1,7,-6}
		};
		
		System.out.println(maxSubRec(matrix));
	}	
		
}
