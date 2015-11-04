package com.jiaxin.company.fb.online;

import org.junit.Test;

public class Island {
	
	private int[][] matrix;
	private int m;
	private int n;
	public int numberIsland(int[][] matrix) {
		this.matrix = matrix;
		this.m = matrix.length;
		this.n = matrix[0].length;
		
		int count = 2;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 1) {
					matrix[i][j] = count++;
					dfs(i, j);
				}
			}
		}
		
		return count - 2;
	}
	
	
	private void dfs(int i, int j) {		
		int[][] direction = {{0,1}, {0,-1}, {1,0}, {-1,0}};
		
		for (int k = 0; k < 4; k++) {
			int newI = i + direction[k][0];
			int newJ = j + direction[k][1];
			if (isValid(newI, newJ)) {
				matrix[newI][newJ] = matrix[i][j];
				dfs(newI, newJ);
			}
		}
	}
	
	private boolean isValid(int i, int j) {
		if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] != 1) {
			return false;
		}
		return true;
	}
	
	@Test
	public void test() {
		int[][] matrix = {{0,0,1,1,0,1,0}, {0,0,1,0,0,1,0}, {1,0,0,0,1,1,0}, {0,1,0,0,0,0,1}};
		System.out.println(numberIsland(matrix));
	}
	
}
