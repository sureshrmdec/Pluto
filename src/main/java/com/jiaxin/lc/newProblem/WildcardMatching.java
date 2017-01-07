package com.jiaxin.lc.newProblem;

import org.junit.Test;

/**
 * 
 * @author jiashan
 *
 * p == 1. 
 * 	* -> true
 *  ?
 *  	s == 1 true
 *      s != 1 false;
 * p != 1
 * * skip i+1, *
 *
 *http://blog.csdn.net/linhuanmars/article/details/21145563
 *http://blog.csdn.net/linhuanmars/article/details/21198049
 *
 */
public class WildcardMatching {
	// DP way
    public boolean isMatch(String s, String p) {
    	if (p.length() == 0) {
			return s.length() == 0;
		}
    	
    	boolean[] result = new boolean[s.length() + 1];
    	result[0] = true;
    	
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
    	System.out.println(isMatch("aa", "a"));
    }
    
}
