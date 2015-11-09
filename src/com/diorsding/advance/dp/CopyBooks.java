package com.diorsding.advance.dp;

/**
 * http://www.lintcode.com/en/problem/copy-books/
 * 
 * Solution:
 * 
 * f[i][j] means minimum cost first i book use j person to copy
 * f[i][j] = max{ f[x][j-1] , w[x + 1][i]}  {x=0->i-1} find a pivot, (x+1, i) books give jth person
 * f[i][1] = w[1][i];  
 * result = f[n][k]
 * 
 * O(n^2k)
 * 
 * @author jiashan
 *
 */
public class CopyBooks {

	public int copyBooks(int[] pages, int k) {
		if (pages == null || pages.length == 0) {
			return 0;
		}
		
		int n = pages.length;
		int[][] f = new int[n + 1][k + 1];
		
		for (int i = 1; i < n; i++) {
			f[i][1] = bookCount(pages, 1, i);
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < k; j++) {
				for (int x = 1; x < i; x++) {
					f[i][j] = Math.max(f[i][j], f[x][j + 1] + bookCount(pages, x + 1, i));
				}
			}
		}
		
		return f[n][k];
    }

	private int bookCount(int[] pages, int start, int end) {
		int count = 0;
		
		for (int x = start; x <= end; x++) {
			count += pages[x];
		}
		
		return count;
	}
	
}
