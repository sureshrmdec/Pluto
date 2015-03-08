package com.jiaxin.company.fb.onsite;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import org.junit.Test;

/**
 * 1. Regular Expression (Recursive + DP)
 * 2. Wild Matching
 * 
 * abc .*c -> true 
 * 
 * @author jiashan
 * 
 *
 */
public class RegularAndWild {

	public boolean isMatchRecursive(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}
		
		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.length() < 1) {
				return false; 
			}
			
			if (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.') {
				return false; 
			}
			
			return isMatchRecursive(s.substring(1), p.substring(1));
		} else {
			if (isMatchRecursive(s, p.substring(2))) {
				return true;
			}
			
			int i = 0;
			while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
				if (isMatchRecursive(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				i++;
			}
		}
		
		return false;
    }
	
	public boolean isMatchDP(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}
		
		int m = s.length();
		int n = p.length();
		
		boolean[][] match = new boolean[m + 1][n + 1];
		match[0][0] = true;
		
		// Initialization. match[0][i] is not always false. depends on how many *
		if (p.length() > 1 && p.charAt(1) == '*') {
			match[0][2] = true;
		}
		
		for (int i = 1; i <= m ; i++) {
			for (int j = 1; j <= n; j++) {
				if (p.charAt(j - 1) != '*') {
					match[i][j] = (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && match[i - 1][j - 1];
				} else {
					if (match[i][j - 2]) {
						match[i][j] = true;
						continue;
					} 
					
					int k = i - 1; // change to index. 
					
					// k - 1 means
					while (k > 0 && (s.charAt(k - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
						if (match[k - 1][j - 2]) {
							match[i][j] = true;
							break;
						}
						k--;
					}
				}
			}
		}
		
		return match[m][n];
	}
	
	
	@Test
	public void test() {
		System.out.println(isMatchRecursive("aab", "c*a*b"));
		System.out.println(isMatchDP("aab", "c*a*b"));
		
		System.out.println(isMatchRecursive("aaa", "ab*a*c*a"));
		System.out.println(isMatchDP("aaa", "ab*a*c*a"));
	}
}
