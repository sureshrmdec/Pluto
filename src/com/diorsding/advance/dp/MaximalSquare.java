package com.diorsding.advance.dp;

import org.junit.Test;

/**
 * http://www.lintcode.com/en/problem/maximal-square/
 * 
 * Find the largest square containing all 1's and return its area
 *
 * Solution: 
 * it's hard to calcuate all 1's directly, we calculate edge.
 * 
 * 1.f[i][j] longest edge can extend from (i,j)
 * 2.f[i][j] = min (f[i-1][j], f[i][j-1],f[i-1][j-1]) + 1; when matrix[i][j] = 1. or f[i][j] = 0; 
 * 3.f[i][0] = matrix[i][0];
 *   f[0][j] = matrix[0][j]; 
 * 4. result = Max {f[i][j]}. 
 * 
 * @author jiashan
 *
 */
public class MaximalSquare {

	public int maxSquare(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		
		int result = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] f = new int[2][n]; // space optimization
		
		for (int i = 0; i < m; i++) {
			f[i % 2][0] = matrix[i][0];
			result = Math.max(result, f[i % 2][0]);
		}
		
		for (int j = 0; j < n; j++) {
			f[0][j] = matrix[0][j];
			result = Math.max(result, f[0][j]);
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 1) {
					f[i % 2][j] = Math.min(f[(i - 1) %2][j - 1], Math.min(f[(i - 1) %2][j], f[i % 2][j - 1])) + 1;
				} else {
					f[i % 2][j] = 0;
				}
				
				result = Math.max(f[i % 2][j], result);
			}
		}
		
		return result * result;
    }
	
	
	@Test
	public void test() {
//		int[][] matrix = {{1,0,1,0,0}, {1,0,1,1,1}, {1,1,1,1,1}, {1,0,0,1,0}};
		int[][] matrix = {{1}, {1}, {1}};
		
		int result = maxSquare(matrix);
		
		System.out.println(result);
	}
}
