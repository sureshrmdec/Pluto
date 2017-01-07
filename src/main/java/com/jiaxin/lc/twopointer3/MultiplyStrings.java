package com.jiaxin.lc.twopointer3;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		int length = num1.length() + num2.length();
		int[] digits = new int[length];
		int carry = 0;
		int i,j;
		
		for (i = num1.length() - 1; i >= 0; i--) {
			carry = 0;
			for (j = num2.length() - 1; j >= 0; j--) {
				int product = Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j)) + carry + digits[i + j + 1];
				carry = product / 10;
				digits[i + j + 1] = product % 10;
			}
			
			digits[i + j + 1] = carry;
		}
		
		StringBuilder sb = new StringBuilder();
		i = 0;
		while (i < length - 1 && digits[i] == 0) {
			i++;
		}
		
		while (i < length) {
			sb.append(digits[i++]);
		}
		
		return sb.toString();
    }

}
