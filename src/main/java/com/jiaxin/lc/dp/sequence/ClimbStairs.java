package com.jiaxin.lc.dp.sequence;


public class ClimbStairs {
	// Recursive
	int[] sum;
	public int climbStairs1(int n) {
		this.sum = new int[n];
		
		for (int i = 0; i < sum.length; i++) {
			sum[i] = Integer.MIN_VALUE;
		}
		
		return search(n - 1);
	}

	private int search(int i) {
		if (i == 0) {
			return 1;
		}
		
		if (i == 1) {
			return 2; 
		}
		
		if (sum[i] != Integer.MIN_VALUE) {
			return sum[i];
		}
		
		sum[i] = search(i - 1) + search(i - 2);
		return sum[i];
	}




	// Non-recursive way -- fast, Fibonacci way  
	public int climbStairs2(int n) {
		if (n == 1) {
			return 1;
		}
		
		if (n == 2) {
			return 2;
		}
		
		int[] sum = new int[n];
		sum[0] = 1;
		sum[1] = 2;
		
		for (int i = 2; i < n; i++) {
			sum[i] = sum[i - 1] + sum[i - 2];
		}
		
		return sum[n - 1];
	}
}
