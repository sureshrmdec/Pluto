package com.jiaxin.lc.dp.matrix;

import java.util.List;

public class Triangle {
	
	// DFS -- Recursive
	int n;
	int[][] sum;
	List<List<Integer>> triangle;
	public int minimumTotal2(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		
		this.n = triangle.size();
		this.sum = new int[n][n];
		this.triangle = triangle;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum[i][j] = Integer.MAX_VALUE;
			}
		}
		
		return search(0, 0);
	}


	private int search(int i, int j) {
		if (i >= n) {
			return 0;
		}
		
		if (sum[i][j] != Integer.MAX_VALUE) {
			return sum[i][j];
		}
		
		sum[i][j] = Math.min(search(i + 1, j), search(i + 1, j + 1)) + triangle.get(i).get(j);
 		
		return sum[i][j];
	}


	// DP way - Iterative
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		
		int n = triangle.size();
		int[][] sum = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			sum[n - 1][i] = triangle.get(n - 1).get(i);
		}
		
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				sum[i][j] = Math.min(sum[i + 1][j], sum[i + 1][j + 1]) + triangle.get(i).get(j);
			}
		}
		
		return sum[0][0];
	}
}
