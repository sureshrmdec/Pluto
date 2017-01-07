package com.jiaxin.company.linkedin;

/**
 * Solution: Two sequence DP
 * distance[i][j] means minimum changes that first i char in word1 associated with first j char in word2.
 * 
 * Three situation: (delete is same to insert)
 * delete s[i],  --> distance[i-1][j] + 1
 * delete s[j],  --> distance[i][j-1] + 1
 * change: s[i] = s[j] (i=j or i!=j), --> distance[i-1][j-1], no operation, if not, --> distance[i-1][j-1] + 1
 *
 * There no relationship between delete,change operation and if i > j, i < j, i = j, it all depends on previous result.
 * Like change, i may not equals j, example: ab acb, just need one step but not delete b and change again.
 * We don't need to judge which condition it is.  Second one will overlap first one if it's smaller.
 */

public class EditDistance {

	public int editDistance(String S, String T) {
		int[][] distance = new int[S.length()][T.length()];
		distance[0][0] = 0;
		
		for (int i = 1; i <= S.length(); i++) {
			distance[i][0] = i;
		}
		
		for (int j = 1; j <= T.length(); j++) {
			distance[0][j] = j;
		}
		
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j < T.length(); j++) {
				distance[i][j] = Math.min(distance[i - 1][j], distance[i][j - 1]);
				distance[i][j] = Math.min(distance[i][j], distance[i - 1][j - 1] 
						+ S.charAt(i) == T.charAt(j)? 0 : 1);
			}
		}
		
		return distance[S.length()][T.length()];
	}
}
