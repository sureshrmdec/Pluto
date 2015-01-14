package com.jiaxin.lc.newProblem;

public class ExcelTitleToNumber {
    public static int titleToNumber(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
    	
		int result = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			result += (s.charAt(i) - 'A' + 1 ) *  Math.pow(26, s.length() - i - 1);
		}
		
    	return result;    
    }
    
    public static void main(String[] args) {
    	System.out.println(titleToNumber("AA"));
    }
    
}
