package com.jiaxin.company.fb.careercup;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * 
 * @author jiashan
 *
 */
public class MinimumWindowSubsring {
	public String minWindow(String S, String T) {
        if (S == null || T == null || S.length() < T.length()) {
			return "";
		}
		
		Map<Character, Integer> dict = new HashMap<Character, Integer>();
		for (char c: T.toCharArray()) {
			if (dict.containsKey(c)) {
				dict.put(c, dict.get(c) + 1);
			} else {
				dict.put(c, 1);
			}
		}
		
		int leftBound = 0;
		int minLength = S.length() + 1;
		String result = "";
		int count = 0;
		
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (dict.containsKey(c)) {
				dict.put(c, dict.get(c) - 1);
				
				if (dict.get(c) >= 0) {
					count++;
				}
				
				while (count == T.length()) {
					char t = S.charAt(leftBound);
					if (dict.containsKey(t)) {
						dict.put(t, dict.get(t) + 1);
						
						if (dict.get(t) > 0) {
							count--;
							if (minLength > i - leftBound + 1) {
								minLength = i - leftBound + 1;
								result = S.substring(leftBound, i + 1);
							}
						}
					}
					
					leftBound++;
				}
			}
		}
		
		return result;
    }

	@Test
	public void test() {
		String S = "ADOBECODEBANC";
		String T = "ABC";
		
		System.out.println(minWindow(S, T));
		System.out.println(minWindow("a", "a"));
	}
}
