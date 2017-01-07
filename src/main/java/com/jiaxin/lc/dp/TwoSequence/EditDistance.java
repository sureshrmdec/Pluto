package com.jiaxin.lc.dp.TwoSequence;

/**
 * 
 * distance[i][j] comes from delete i, delete j, or just edit. 
 * We need to find the smallest according to the question. 
 * 
 * f[i][j] = MIN(f[i - 1][j - 1], f[i-1][j] + 1, f[i][j-1] + 1) // a[i] == b[j]
 * f[i][j] = MIN(f[i - 1][j - 1] + 1, f[i-1][j] + 1, f[i][j-1] + 1) // a[i] != b[j]
 * 
 * @author jiashan
 *
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
    		return 0;
    	}
    	
    	int m = word1.length();
    	int n = word2.length();
    	
    	int[][] distance = new int[m + 1][n + 1];
    	distance[0][0] = 0;
    	for (int i = 1; i <= m; i++) {
    		distance[i][0] = i;
    	}
    	
    	for (int j = 1; j <= n; j++) {
    		distance[0][j] = j;
    	}
    	
    	for (int i = 1; i <= m; i++) {
    		for (int j = 1; j <= n; j++) {
    			// Find minimum.
    			distance[i][j] = Math.min(distance[i - 1][j], distance[i][j - 1]) + 1;
    			distance[i][j] = Math.min(distance[i][j], distance[i - 1][j - 1] 
    			    + (word1.charAt(i - 1) == word2.charAt(j - 1)? 0:1));
    		}
    	}
    	
    	return distance[m][n];
    }
}
