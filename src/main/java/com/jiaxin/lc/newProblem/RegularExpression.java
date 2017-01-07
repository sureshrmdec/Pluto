package com.jiaxin.lc.newProblem;

import org.junit.Test;

/**
 * 
 * @author jiashan
 * If the next character of p is NOT ‘*’, then it must match the current character of s. 
 * 		Continue pattern matching with the next character of both s and p.
 * 
 * If the next character of p is ‘*’, then we do a brute force exhaustive matching of 0, 1, 
 * 		or more repeats of current character of p… Until we could not match any more characters.
 *
 * Reference: 
 * http://leetcode.com/2011/09/regular-expression-matching.html
 * http://www.programcreek.com/2012/12/leetcode-regular-expression-matching-in-java/
 * http://simpleandstupid.com/2014/10/14/regular-expression-matching-leetcode-%E8%A7%A3%E9%A2%98%E7%AC%94%E8%AE%B0/
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 */
public class RegularExpression {
    public boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}
    	
		// case1: second char of p is not '*' + special case p == 1. same logic
		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.length() < 1) {
				return false; 
			}
			
			if ((s.charAt(0) != p.charAt(0)) && p.charAt(0) != '.') {
				return false;
			}
			
			return isMatch(s.substring(1), p.substring(1));
		} else {
			// * match 0 preceding element
			if (isMatch(s, p.substring(2))) {
				return true;
			}
			
			// * match one or more preceding element. compare rests.
			int i = 0;
			 while (i < s.length() && ((s.charAt(i) == p.charAt(0)) || p.charAt(0) == '.')) {
				 if (isMatch(s.substring(i + 1), p.substring(2))) {
					 return true;
				 }
				 i++;
			 }
			 
		}
		
    	return false;
    }
    
    @Test
    public void test() {
    	System.out.println(isMatch("", ""));
    	
    	// p.length() == 1
    	System.out.println(isMatch("ab", "b"));
    	System.out.println(isMatch("a", "b"));
    	System.out.println(isMatch("a", "."));
    	System.out.println(isMatch("ab", "."));
    	
    	// p.charAt(1) != '*'
    	System.out.println(isMatch("ab", "ab*c"));
    	
    	// p.charAt(1) == '*'
    	System.out.println(isMatch("c", "a*c"));
    	System.out.println(isMatch("c", ".*c"));
    	System.out.println(isMatch("ab", ".*c"));
    	System.out.println(isMatch("ab", ".*"));
    	System.out.println(isMatch("aab", "c*a*b"));
    	
    }
}
