package com.jiaxin.lc.newProblem;

import org.junit.Test;

public class FractionToDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		String result = String.valueOf((double)numerator / (double)denominator);
		
		if (result.charAt(result.length() - 1) == '0' && result.charAt(1) == '.') {
			result = result.substring(0, 1);
		}
		
		if (result.length() > 3 && result.charAt(1) == '.') {
			result = result.substring(0, 3);
			StringBuilder sb = new StringBuilder(result);
			sb.insert(2, "(");
			sb.append(")");
			
			result = sb.toString();
		}
		
		return result;
    }
	
	@Test
	public void test() {
		System.out.println(fractionToDecimal(2, 1));
	}
}
