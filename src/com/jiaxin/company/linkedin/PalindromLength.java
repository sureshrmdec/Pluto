package com.jiaxin.company.linkedin;

import org.junit.Test;

public class PalindromLength {
	/* Write a function to compute the maximum length palindromic sub-sequence of an array. 
	 * 
	 * They ask subsequnece but not subarray
	 * 
	 * A palindrome is a sequence which is equal to its reverse. 
	 * A sub-sequence of an array is a sequence which can be constructed by removing elements of the array. 
	 * Ex: Given [4,1,2,3,4,5,6,5,4,3,4,4,4,4,4,4,4] should return 10 (all 4's) 
	
	class Interview { 
		public static int maxLengthPalindrome(int[] values) { 
		//ur implementation here 
	}
	
	*/
	
	// Recursive -> O(n^2)
	public int maxLengthPalindrome(int[] values, int i, int j) {
		if (j <= i) {
			return j - i + 1;
		}
		if (values[i] == values[j]) {
			return 2 + maxLengthPalindrome(values, i + 1, j - 1);
		}
		
		return Math.max(maxLengthPalindrome(values, i + 1, j), maxLengthPalindrome(values, i, j - 1));
	}

	// DP dp[i, j] be the maximum length of palindromes considering in the input array A from i to j.
	// Consider each length k of a range, k = 2..n 
	// For each length k, calculate all OPT(i, i+k) entries using the previously calculated 
	// entries with shorter length. 
	public int maxLengthPalindromeDP(int[] values, int start, int length) {
		int[][] dp = new int[length + 1][length + 1];
		
		for (int i = 1; i < dp.length; i++) {
			dp[i][i] = 1;
		}
		
		for (int l = 2; l <= length; l++) {
			for (int i = 1; i <= length - l +1; i++) {
				int j = i + l - 1;
				
				if (values[i - 1] == values[j - 1]) {
					dp[i][j] = 2 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
				}
			}
		}
		
		return dp[1][length];
	}
	
	
	
	@Test
	public void test() {
//		int[] values = {4,1,2,3,4,5,6,5,4,3,4,4,4,4,4,4,4};
		int[] values = {4,5,3,5,4};
		System.out.println(maxLengthPalindromeDP(values, 0, values.length));
	}
}
