package com.jiaxin.lc.dp.TwoSequence;

import org.junit.Test;

/**
 * For "ABCD" and "EDCA", the LCS is "A" (or D or C), return 1
 * For "ABCD" and "EACB", the LCS is "AC", return 2
 *
 * @author jiashan
 *
 */
public class LongestCommonSequence {
	public int longestCommonSubsequence(String A, String B) {
		if (A == null || B == null) {
			return 0;
		}
		int m = A.length();
		int n = B.length();
		
		int[][] length = new int[m + 1][n + 1];
		
		// Initialization: length[i][0]  length[0][j] = 0;
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					length[i][j] = length[i - 1][j - 1] + 1; 
				} else {
					length[i][j] = Math.max(length[i - 1][j], length[i][j - 1]);
				}
			}
		}
		
		return length[m][n];
    }
	
	@Test
	public void test() {
//		String A1 = "ABCD"; String B1 = "EDCA";
//		System.out.println(longestCommonSubsequence(A1, B1));
		String A2 = "ABCD"; String B2 = "EACB";
		System.out.println(longestCommonSubsequence(A2, B2));
	}
}
