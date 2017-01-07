package com.jiaxin.lc.newProblem;

import org.junit.Test;

// Given two strings S and T, determine if they are both one edit distance apart.
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
    	if (s == null || t == null) {
    		return false;
    	}
    	
    	if (s.length() > t.length()) {
    		String temp = s;
    		s = t;
    		t = temp;
    	}
    	
    	if (t.length() - s.length() > 1) {
    		return false;
    	}
    	
    	
    	boolean flag = false;
    	for (int i = 0, j= 0; i < s.length(); i++,j++) {
    		if (s.charAt(i) != t.charAt(j)) {
    			if (flag) {
    				return false;
    			}
    			
    			flag = true;
    			
    			if (s.length() != t.length()) {
    				i--;
    			}
    		}
    	}
    	
    	// Test case:  "c" "c" -> false. one edit distance should be strictly, not less than 1 
    	// flag false size == -> false
    	// flag true  size == -> true
    	// flag false size != -> true
    	// flag true  size != -> true
    	
		return flag || s.length() != t.length();
    }
}
