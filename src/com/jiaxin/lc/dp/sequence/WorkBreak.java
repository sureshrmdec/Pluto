package com.jiaxin.lc.dp.sequence;

import java.util.Set;

/**
 * take care index of substring.
 * 
 * @author jiashan
 *
 */
public class WorkBreak {
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
}
