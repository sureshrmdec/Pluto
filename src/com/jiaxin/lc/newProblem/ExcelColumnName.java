package com.jiaxin.lc.newProblem;

public class ExcelColumnName {
	public String convertToTitle(int n) {
		if (n <= 0) {
			return null;
		}
		
		String result = "";
		
		while (n > 0) {
			int reminder = n % 26;
			n = n / 26;
			
			if (n == 0) {
				result += 'Z';
				n--;
			} else {
				result += (char)('A' - 1 + reminder);
			}
		}
		
		return result;
	}
}
