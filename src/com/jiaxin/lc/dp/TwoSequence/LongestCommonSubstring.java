package com.jiaxin.lc.dp.TwoSequence;

import org.junit.Test;

/**
 * Given A="ABCD", B="CBCE", return  2
 * 
 * state: f[i][j] end with i,j. same to LIS. end is important
 * 
 * @author jiashan
 *
 */
public class LongestCommonSubstring {
    public int longestCommonSubstring(String A, String B) {
		if (A == null || B == null) {
			return 0;
		}
		
		int m = A.length();
		int n = B.length();
		
		int[][] length = new int[m + 1][n + 1];
		int max = 0;
		
		// Initialization. 
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					length[i][j] = length[i - 1][j - 1] + 1; 
				} else {
					length[i][j] = 0;
				}
				
				max = Math.max(max, length[i][j]);
			}
		}
		
    	return max;
    }
    
    @Test
    public void test() {
    	String A = "ABCD";
    	String B = "CBCE"; 
    	
    	System.out.println(longestCommonSubstring(A, B));
    }
}
