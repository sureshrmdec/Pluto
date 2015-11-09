package com.diorsding.advance.dp;

import org.junit.Test;

/**
 * http://www.lintcode.com/en/problem/longest-increasing-continuous-subsequence/
 * continuous subsequence -> subArray
 * 
 * Solution: Two Pass. left -> right. right -> left. find longest sequence O(n) time + O(1) space
 * 
 * 
 * http://www.lintcode.com/en/problem/longest-increasing-continuous-subsequence-ii/
 * Ski Problem. like water goes from high to slow.(find longest ski path)
 * Solution: 
 * 1.dp[i][j] means longest path start with (i,j) (hight point).
 * it depends on four direction.
 * 2. hard to write transition formula, so we use memorize search.
 * 3. result = max{f[i][j]}
 * 
 * @author jiashan
 *
 */
public class LongestIncreasingContinuousSubsequenceII {
	
	int[][] f;
	boolean[][] flag;
	int m, n;
	public int longestIncreasingContinuousSubsequenceII(int[][] A) {
		if (A == null || A.length == 0 || A[0].length == 0) {
			return 0;
		}
		
		this.m = A.length;
		this.n = A[0].length;
		
		this.f = new int[m][n];
		this.flag = new boolean[m][n];
		int result = 0;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				f[i][j] = search(i, j, A);
				result = Math.max(result, f[i][j]);
			}
		}
		
		return result;
    }


	private int search(int x, int y, int[][] A) {
		if (flag[x][y]) {
			return f[x][y];
		}
		
		int result = 1;

		// Four direction
		if (x - 1 >= 0 && x - 1 < m && y >= 0 && y < n) {
			if (A[x][y] > A[x - 1][y]) result = Math.max(result, search(x - 1, y, A) + 1); 
		}
		
		if (x + 1 >= 0 && x + 1 < m && y >= 0 && y < n) {
			if (A[x][y] > A[x + 1][y]) result = Math.max(result, search(x + 1, y, A) + 1); 
		}
		
		if (x >= 0 && x < m && y - 1 >= 0 && y - 1 < n) {
			if (A[x][y] > A[x][y - 1]) result = Math.max(result, search(x, y - 1, A) + 1); 
		}
		
		if (x >= 0 && x < m && y + 1 >= 0 && y + 1 < n) {
			if (A[x][y] > A[x][y + 1]) result = Math.max(result, search(x, y + 1, A) + 1); 
		}
		
		flag[x][y] = true;
		f[x][y] = result;
		
		return result;
	}
	
//	int[] dx = {1, -1, 0, 0};
//	int[] dy = {0, 0, 1, -1};
	
//	int nx, ny;
	
//	for (int i = 0; i < 4; i++) {
//		nx = x + dx[i];
//		ny = y + dy[i];
//		
//		if (0 <= nx && nx < m && 0 <= ny && ny < n) {
//			if (A[x][y] > A[nx][ny]) {
//				result = Math.max(result, search(nx, ny, A) + 1);
//			}
//		}
//	}
// 
// This also works, make code simplier. 
	
	
	public int longestIncreasingContinuousSubsequence(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		int result = 0;
		int count = 1;
		
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] > A[i + 1]) {
				count++;
			} else {
				result = Math.max(result, count);
				count = 1;
			}
		}
		
		result = Math.max(result, count);
		count = 1;
		
		for (int i = A.length - 1; i - 1 >= 0; i--) {
			if (A[i] > A[i - 1]) {
				count++;
			} else {
				result = Math.max(result, count);
				count = 1;
			}
		}
		
		result = Math.max(result, count);
		
		return result;
    }
	
	@Test
	public void test() {	
//		int[] A = {5,4,2,1,3};
		int[] A = {5,1,2,3,0, 4};
		System.out.println(longestIncreasingContinuousSubsequence(A));
		
		int[][] B = {{1,2,3,4,5},{16,17,24,23,6},{15,18,25,22,7},{14,19,20,21,8},{13,12,11,10,9}};		
		System.out.println(longestIncreasingContinuousSubsequenceII(B));
	}
}
