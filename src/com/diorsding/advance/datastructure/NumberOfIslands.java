package com.diorsding.advance.datastructure;

/**
 * http://www.lintcode.com/en/problem/number-of-islands/
 * 
 * http://www.lintcode.com/en/problem/number-of-islands-ii/
 * 
 * @author jiashan
 *
 */
public class NumberOfIslands {

	int m, n;
	public int numIslands(boolean[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		
		this.m = grid.length;
		this.n = grid[0].length;
		
		int count = 0;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!grid[i][j]) {
					continue;
				}
				
				count++;
				dfs(grid, i, j);
			}
		}
		
		return count;
    }
	
	private void dfs(boolean[][] grid, int i, int j) {
		if (i < 0 || i >= m || j < 0 || j >= n) {
			return;
		}
		
		if (grid[i][j]) {
			grid[i][j] = false;
			dfs(grid, i - 1, j);
			dfs(grid, i + 1, j);
			dfs(grid, i, j - 1);
			dfs(grid, i, j + 1);
		}
	}
	
	
	
	
	
}
