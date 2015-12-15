package com.jiaxin.company.twosigma;

import org.junit.Test;

/**
 * http://www.programcreek.com/2014/06/leetcode-wildcard-matching-java/
 * http://yucoding.blogspot.com/2013/02/leetcode-question-123-wildcard-matching.html
 * @author jiashan
 *
 */
public class WildMatching {

	public boolean isMatch(String s, String p) {
    	if (p.length() == 0) {
			return s.length() == 0;
		}
    	
    	boolean[] result = new boolean[s.length() + 1];
    	result[0] = true;
    	
    	for (int j = 0; j < p.length(); j++) {
    		if (p.charAt(j) != '*') {
    			for (int i = 0; i < s.length(); i++) {
    				result[i + 1] = result[i] && (p.charAt(i) == '?' || s.charAt(i) == p.charAt(j));
    			}
    		} else {
    			int i = 0;
    			while (i <= s.length() && !result[i]) {
    				i++;
    			}
    			
    			for (;i < s.length(); i++) {
    				result[i] = true;
    			}
    		}
    		
    	}
    	
    	
    	
    	for (int j = 0; j < p.length(); j++) {
    		if (p.charAt(j) != '*') {
    			for (int i = 0; i < s.length(); i++) {
    				result[i + 1] = result[i] && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j));
    			}
    		} else {
    			int i = 0;
    			while (i <= s.length() && !result[i]) {
    				i++;
    			}
    			
    			for (; i < s.length(); i++) {
    				result[i] = true;
    			}
    		}
    		
    		result[0] = result[0] && p.charAt(j) == '*';
    	}
		
    	return result[s.length()];
    	
    }
    
    @Test
    public void test() {
    	System.out.println(isMatch("aa", "a*"));
    }
    
}
