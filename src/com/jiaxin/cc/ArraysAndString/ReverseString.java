package com.jiaxin.cc.ArraysAndString;

/**
 * 1.2 Implement a function reverse which reverse a null-terminated string
 */
public class ReverseString {
	// Java Version immutable way
	public String reverse(String str) {
		StringBuffer sb = new StringBuffer();
		
		for (int i = str.length() - 1; i >= 0; i--) {
			char value = str.charAt(i);
			sb.append(value);
		}
		
		return sb.toString();
	}
	
	
	// C++ mutable way -- 这个只是reverse 一个word, remove sentence 也能会写
	/*
	void reverse(char *str) {
	    char* end = str;
	    char tmp;
	    if (str) {
	        while (*end) {
	            ++end;
	        }
	        --end;
	        
	        while(str < end) {
	            tmp = *str;
	            *str++ = *end;
	            *end-- = tmp;
	        }
	    }
	}
	*/
}
