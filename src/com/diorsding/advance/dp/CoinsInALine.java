package com.diorsding.advance.dp;

import javax.media.j3d.Leaf;

import org.junit.Test;

/**
 * Difference is we use memorize search, start from f(n) but not f(1)
 * 
 * http://www.lintcode.com/en/problem/coins-in-a-line/
 * 
 * Solution:
 * 1. f[i] means f[i] first hand people wins or not when i coins left.
 * 2. f[i] = (f(i - 2) && f(i - 3)) || (f(i - 3) && f(i - 4))
 * 3. f[1] true. f[2] true f[3] false f[4]....
 * 4. result = f[n]
 * 
 *         n            --> first hand
 *    n-1      n-2      --> second hand
 * n-2  n-3  n-3  n-4   --> first hand (now, We get transition formula.)
 *   
 * can not use f[n] directly, because we don't know if f[n] really equals to true|false, or not have value yet.
 * 
 * 
 * http://www.lintcode.com/en/problem/coins-in-a-line-ii/
 * Solution: 
 * 1. f[i] means most value first hand gets when x coins left.
 * 2. f[i] = Max(min(f[i-2], f[i-3]) + a[n-i], min(f[i-3], f[i-4]) + a[n-i] + a[n-i+1])
 * min means make f[i] as small as possible. second hand always be smart to make f[i] as small as possible.
 * 3. f[0] = a[n - 0];
 * 4. result = f[n]
 * 
 * result > sum / 2. result > half of total
 *   
 *   
 * 
 * http://www.lintcode.com/en/problem/coins-in-a-line-iii/
 * Solution: 
 *
 * 1. f[x][y] means most value first hand gets when [x...y] coins left.
 * 2. f[x][y] = Max(min(f[x+2][y], f[x+1][y-1]) + a[x], min(f[x][y-2], f[x+1][y-1]) + a[y])
 * 3. f[x][x] = a[x]; f[x][x+1] = max(a[x], a[x+1])
 * 4. result = f[0][n]
 * 
 * 
 * Save time on F(x) calculation. Same as Fibonacci Recursive way. Avoid duplicate calculation. 
 * 
 * 
 * 
 * 
 * @author jiashan
 *
 */
public class CoinsInALine {

	public boolean firstWillWin(int n) {
		int[] f = new int[n + 1];
		// can also use flag[] + boolean[] 
		return search(n, f);
    }

	
	private boolean search(int n, int[] f) {
		if (f[n] != 0) {
			return f[n] == 1 ? false : true;
		}
		
		if (n <= 0 || n == 3) {
			f[n] = 1;
		} else if (n == 1 || n == 2) {
			f[n] = 2;
		} else {
			if ((search(n - 2, f) && search(n - 3, f)) || (search(n - 3, f) && search(n - 4, f))) {
				f[n] = 2;
			} else {
				f[n] = 1;
			}	
		}
		
		return f[n] == 1 ? false : true;
	}


	
	public boolean firstWillWinII(int[] values) {
		int[] f = new int[values.length + 1];
		boolean[] flag = new boolean[values.length + 1];
		int sum = 0;
		
		for (int now : values) {
			sum += now; 
		}
		
		return searchII(values.length, f, flag, values) > sum / 2;
    }
	
	
	private int searchII(int n, int[] f, boolean[] flag, int[] values) {
		if (flag[n]) {
			return f[n];
		}
		
		flag[n] = true;
		if (n == 0) {
			f[n] = 0;
		} else if (n == 1) {
			f[n] = values[values.length - 1];
		} else if (n == 2) {
			f[n] = values[values.length - 1] + values[values.length - 2];
		} else if (n == 3) {
			f[n] = values[values.length - 2] + values[values.length - 3];
		} else {
			f[n] = Math.max(Math.min(searchII(n - 2, f, flag, values), searchII(n - 3, f, flag, values)) 
					+ values[values.length - n], 
					Math.min(searchII(n - 3, f, flag, values), searchII(n - 4, f, flag, values)) 
					+ values[values.length - n] + values[values.length - n + 1]);
		}
		
		return f[n];
	}


	public boolean firstWillWinIII(int[] values) {
		if (values == null || values.length == 0) {
			return false;
		}
		
		int n = values.length;
		int[][] f = new int[n + 1][n + 1];
		boolean[][] flag = new boolean[n + 1][n + 1];
		
		int sum = 0;
		for (int value : values) {
			sum += value;
		}
		
		return searchIII(0, values.length - 1, f, flag, values) > sum / 2;
    }
	
	
	private int searchIII(int left, int right, int[][] f, boolean[][] flag, int[] values) {
		if (flag[left][right]) {
			return f[left][right];
		}
		
		flag[left][right] = true;
		if (left > right) {
			f[left][right] = 0;
		} else if (left == right) {
			f[left][right] = values[left];
		} else if (left + 1 == right) {
			f[left][right] = Math.max(values[left], values[right]);
		} else {
			int left_value = Math.min(searchIII(left + 2, right, f, flag, values), 
					searchIII(left + 1, right - 1, f, flag, values)) + values[left];
			int right_value = Math.min(searchIII(left, right - 2, f, flag, values), 
					searchIII(left + 1, right - 1, f, flag, values)) + values[left];
			
			f[left][right] = Math.max(left_value, right_value);
		}
		
		return f[left][right];
	}


	@Test
	public void test() {
		System.out.println(firstWillWin(4));
	}
	
	
}
