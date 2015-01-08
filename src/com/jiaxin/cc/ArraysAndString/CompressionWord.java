package com.jiaxin.cc.ArraysAndString;
/**
 * 
 * 1.5 Implemtnt a method to perform basic string compression using the counts of repeated characters.
 * Like aabcccccaaa --> a2b1c5a3
 * 
 * 书上说这种方法不好, 因为abc时候会a1b1c1, 但我们处理一下判断一下count == 1就好
 * 注意最后还要append一下，要不最后一次的没append上去
 * 
 * @author jeffwan
 * @date May 5, 2014
 */

public class CompressionWord {	
	public String compression(String s) {
	    if (s == null || s.length() == 0) {
	        return null;
	    }
	    
	    int count = 1;
	    char last = s.charAt(0);
	    String result = "";
	    
	    for (int i = 1; i < s.length(); i++) {
	        if (s.charAt(i) == last) {
	            count++;
	        } else {
	            result += count == 1? last : last + "" + count;
	            count = 1;
	            last = s.charAt(i);
	        }
	    }

	    result += count == 1? last : last + "" + count;
	    return result;
	}
	
	
}
