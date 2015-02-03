package com.jiaxin.company.linkedin;

import org.junit.Test;

public class IsNumber {
	// trim head & tail
	// remove first + - 
	// . 
	
	public boolean isNumber(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		
		
		int i = 0;
		int j = s.length() - 1;
		
		while (i <= j && s.charAt(i) == ' ') {
			i++;
		}
		
		if (i > j) {
			return false;
		}
		
		while (i <= j && s.charAt(j) == ' ') {
			j--;
		}
		 
		if (s.charAt(i) == '+' || s.charAt(i) == '-') {
			i++;
		}
		
		
		boolean num = false;
		boolean dot = false;
		boolean exp = false;
		
		// . digit +- alpha
		while (i <= j) {
			int c = s.charAt(i);
			
			if (c >= '0' && c <= '9') {
				num = true; 
			} else if (c == '.') {
				if (dot || exp || !num) {
					return false;
				}
				dot = true;
			} else if (c == 'e') {
				if (exp) {
					return false;
				}
				exp = true;
				num = false;
			} else if (c == '+' || c == '-') {
				if (i != 0 && s.charAt(i - 1) != 'e') {
					return false;
				}
			} else {
				return false;
			}
			i++;
		}
		
		return num;
	}
	

	@Test
	public void test() {
		// .1 -> true? 
		// e+1 ->
		// e .
		// 7e  e can't be tail. 
		
		System.out.println(isNumber("+.3"));
	}
}
