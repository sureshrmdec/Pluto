package com.jiaxin.lc.dp.TwoSequence;

import org.junit.Test;

public class DistinctSubsequence {
	public int numDistinct(String S, String T) {
		if (S == null || T == null || S.length() < T.length()) {
			return 0;
		}

		int[][] num = new int[S.length() + 1][T.length() + 1];
		num[0][0] = 1; 
		
		for (int i = 1; i <= S.length(); i++) {
			num[i][0] = 1;
		}
	    
	    for (int i = 1; i <= S.length(); i++) {
	    	for (int j = 1; j <= T.length(); j++) {
	    		num[i][j] = num[i - 1][j];

	    		if (S.charAt(i - 1) == T.charAt(j - 1)) {
	    			num[i][j] += num[i - 1][j - 1];
	    		}
	    	}
	    }

	    return num[S.length()][T.length()];
	}
	
	@Test
	public void test() {
		System.out.println(numDistinct("aabc", "ab"));
		System.out.println(numDistinct("aabc", "aaaa"));
		System.out.println(numDistinct("aabc", "aabc"));
		System.out.println(numDistinct("aabc", "a"));
		System.out.println(numDistinct("aabc", "ddf"));
		System.out.println(numDistinct("b", "b"));
		
	}
}
