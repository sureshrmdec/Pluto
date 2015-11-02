package com.jiaxin.lc.dp.matrix;

/**
 * 
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * You can only move either down or right at any point in time.
 * 
 * State: result[i][j]  minSum to (i, j)
 * Transition: result[i][j]  comes from Math.min(result[i - 1][j], result[i][j - 1]) + grid[i][j] 
 * 
 * @author jiashan
 *
 */

public class ManimumPathSum {
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		
		int m = grid.length;
		int n = grid[0].length;
		
		int[][] result = new int[m][n];
		result[0][0] = grid[0][0];
		
		// Initialization
		for (int i = 1; i < m; i++) {
			result[i][0] = result[i - 1][0] + grid[i][0];
		}
		
		for (int j = 1; j < n; j++) {
			result[0][j] = result[0][j - 1] + grid[0][j];
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]) + grid[m][n];
			}
		}
		
		return result[m - 1][n - 1];
	}
}
