package com.diorsding.advance.dp;

/**
 * http://www.lintcode.com/en/problem/post-office-problem/
 * 
 * Solution:
 * f[i][j] means minimum cost prev i house build j post office 
 * f[i][j] = min {f[x][i - 1] + dis[x + 1][i]}
 * f[i][1] = dis[1][j];
 * result = f[n][k]
 *  
 *  O(n^2k)
 * @author jiashan
 *
 */
public class PostOfficeProblem {

	public int postOffice(int[] A, int k) {
		
		
		return 0;
    }
}
