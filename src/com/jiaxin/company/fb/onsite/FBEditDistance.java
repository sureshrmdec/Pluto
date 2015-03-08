package com.jiaxin.company.fb.onsite;

import com.jiaxin.company.amazon.KCloset;

/**
 * 1. One edit distance
 * 2. How many edits between two word
 * 3. Longest substring with at most two distinct characters
 * 
 * @author jiashan
 *
 */
public class FBEditDistance {
	// 1. One edit distance -- 
	public boolean isOneEditDistance(String s, String t) {
	    if (s == null || t == null) {
	        return false; 
	    }
	    
	    if (Math.abs(s.length() - t.length()) > 1) {
	        return false;
	    }
	    
	    // s -> longer string
	    if (s.length() < t.length()) {
	        String temp = t; 
	        t = s;
	        s = temp;
	    }
	    
	    boolean flag = false; 
	    for (int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) {
	        if (s.charAt(i) != t.charAt(j)) {
	            if (flag) {
	                return false;
	            }
	            
	            flag = true; 
	            
	            if (s.length() != t.length()) {
	                j--;
	            }
	        }
	    }
	    
	    return flag || s.length() != t.length();
	}
	
	// 2. Edit distance
	public int editDistance(String s, String t) {
		if (s == null || t == null) {
			return 0;
		}
		
		int[][] distance = new int[s.length() + 1][t.length() + 1];
		distance[0][0] = 0;
		
		for (int i = 1; i <= s.length(); i++) {
			distance[i][0] = i;
		}
		
		for (int j = 1; j <= t.length(); j++) {
			distance[0][j] = j;
		}
		
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j < t.length(); j++) {
				distance[i][j] = Math.min(distance[i - 1][j], distance[i][j - 1]) + 1; 
				distance[i][j] = Math.min(distance[i][j], distance[i - 1][j - 1] + s.charAt(i - 1) == t.charAt(j - 1)? 0 : 1);
			}
		}
		
		return distance[s.length()][t.length()];
	}
	
	
	// 3. at most two distinct character
	
}
