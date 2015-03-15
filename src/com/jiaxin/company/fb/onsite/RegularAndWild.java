package com.jiaxin.company.fb.onsite;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1. Regular Expression (Recursive + DP)
 * abc .*c -> true
 * 
 * 2. Wild Matching
 * Diff is * neans any sequence of characters(zero or more in regular expression). not rely on previous. 
 * aab c*a*b -> false. because c can't be elminated here.  
 * 
 * 
 * 3. regular expression only contains *.
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
					
					int k = i; // change to index. 
					
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
	public void testRegular() {
		System.out.println(isMatchRecursive("aab", "c*a*b"));
		System.out.println(isMatchDP("aab", "c*a*b"));
		
		System.out.println(isMatchRecursive("aaa", "ab*a*c*a"));
		System.out.println(isMatchDP("aaa", "ab*a*c*a"));
	}
	
	public boolean wildMatch(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}
		
		boolean[] result = new boolean[s.length() + 1];
		result[0] = true;
		
		for (int j = 0; j < p.length(); j++) {
			if (p.charAt(j) != '*') {
				for (int i = s.length() - 1; i >= 0; i--) {
					result[i + 1] = result[i] && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j));
				}
			} else {
				int i = 0;
				while (i <= s.length() && !result[i]) {
					i++;
				}
				
				for (; i <= s.length(); i++) {
					result[i] = true;
				}
			}
			
			result[0] = result[0] && p.charAt(j) == '*';
		}
		
		return result[s.length()];
	}
	
	@Test
	public void testWildCard() {
//		System.out.println(wildMatch("aa", "*"));  // true
		System.out.println(wildMatch("aa", "a*")); // true
		System.out.println(wildMatch("aab", "c*a*b"));
	}
	
	
	
	public boolean isMatchOnlyStar(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
 		}
		
		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.length() < 1) {
				return false;
			}
			
			if (s.charAt(0) != p.charAt(0)) {
				return false;
			}
			
			return isMatchOnlyStar(s.substring(1), p.substring(1));
		} else {
			if (isMatchOnlyStar(s, p.substring(2))) {
				return true;
			}
			
			int i = 0;
			while ((i + 1) < s.length() && s.charAt(i) == p.charAt(0)) {
				if (isMatchOnlyStar(s.substring(i + 1), p.substring(2))) {
					return true; 
				}
				i++;
			}
		}
		
		return false; 
	}
	
	@Test
	public void testSingleStar() {
		Assert.assertTrue(isMatchOnlyStar("aab", "aab"));
		Assert.assertTrue(isMatchOnlyStar("aaab", "a*b"));
		Assert.assertFalse(isMatchOnlyStar("aac", "a*b"));
		Assert.assertFalse(isMatchOnlyStar("aabc", "aab"));
		Assert.assertFalse(isMatchOnlyStar("aa", "aab"));
		Assert.assertTrue(isMatchOnlyStar("a", "b*a"));
		Assert.assertTrue(isMatchOnlyStar("a", "a*a"));
		Assert.assertTrue(isMatchOnlyStar("ab", "aa*b*b"));
		Assert.assertTrue(isMatchOnlyStar("", "a*a*a*a*"));
		Assert.assertFalse(isMatchOnlyStar("cb", "a*b"));
	}
}
