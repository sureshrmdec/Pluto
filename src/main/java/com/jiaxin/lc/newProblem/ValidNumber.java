package com.jiaxin.lc.newProblem;

import org.junit.Test;

/**
 * 
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
 *
 * trim left, right space. 
 * left 0
 * . e position
 * 
 * case: 
 * e9 -> false. e can't be start;
 * "1 " -> true. 
 * " 005047e+6" -> true. + or - could append e
 * 0e -> false. num = false here, we return num
 */
public class ValidNumber {
	public boolean isNumber(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		
		int i = 0; 
		int right = s.length() - 1;
		
		while (i <= right && Character.isWhitespace(s.charAt(i))) {
			i++;
		}
		
		if (i > right) {
			return false;
		}
		
		while (i <= right && Character.isWhitespace(s.charAt(right))) {
			right--;
		}
		
		if ((s.charAt(i) == '+') || (s.charAt(i) == '-')) {
			i++;
		}
		
		boolean num = false;
		boolean dot = false;
		boolean exp = false; 
		
		while (i <= right) {
			char c = s.charAt(i);
			
			if (Character.isDigit(c)) {
				num = true;
			} else if (c == '.') {
				if (dot || exp) return false;
				dot = true;
			} else if (c == 'e') {
				if (exp || num == false) return false;
				exp = true;
				num = false;
			} else if (c == '+' || c == '-') {
			    if (s.charAt(i - 1) != 'e') return false;
			} else {
				return false;
			}
			
			i++;
		}
		
		return num;
    }
	
	@Test
	public void test() {
		System.out.println(isNumber("-1."));
	}
}
