package com.jiaxin.lc.dp.sequence;

import java.util.HashSet;
import java.util.Set;


import org.junit.Test;


/**
 * take care index of substring.
 * 
 * @author jiashan
 *
 */
public class WorkBreak {
	// Recursive Way
	public boolean wordBreakRecursive(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
			return false;
		}
		
		int maxLength = getMaxLenth(dict);
		boolean result = segment(dict, maxLength, s);
		
		return result;
	}
	
	private boolean segment(Set<String> dict, int maxLength, String s) {
		if (s.isEmpty()) {
			return true; // cut to last number
		}
		
		for (int i = 1; i <= s.length() && i <= maxLength; i++) {
			String prefix = s.substring(0, i);
			if (dict.contains(prefix)) {
				if (segment(dict, maxLength, s.substring(i, s.length()))) {
					return true; 
				}
			}
		}
		
		return false;
	}

	// DP Way
	public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
			return false;
		}
		
		int maxLength = getMaxLenth(dict);
		
		boolean[] canSegment = new boolean[s.length() + 1];
		canSegment[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= maxLength && j <= i; j++) {
				String word = s.substring(i - j, i);
				
				if (canSegment[i - j] && dict.contains(word)) {
					canSegment[i] = true;
					break;
				}
			}
		}
		
		return canSegment[s.length()];
    }
    
    private int getMaxLenth(Set<String> dict) {
		int length = 0;
		for (String str: dict) {
			length = Math.max(length, str.length());
		}
				
		return length;
	}
    
    
    @Test
    public void test() {
    	Set<String> dict = new HashSet<String>();
    	dict.add("leet");
    	dict.add("code");
    	dict.add("s");
    	
    	System.out.println(wordBreak("leetcode", dict));
    	System.out.println(wordBreakRecursive("leetcode", dict));

    	System.out.println(wordBreak("leetcodes", dict));
    	System.out.println(wordBreakRecursive("leetcodes", dict));

    	System.out.println(wordBreak("leetscodes", dict));
    	System.out.println(wordBreakRecursive("leetscodes", dict));
    }
}
