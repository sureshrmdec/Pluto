package com.jiaxin.lc.twopointer3;

public class AddBinary {
	
	// "11" "1" -> "110"
	public String addBinary(String a, String b) {
		if (a.length() < b.length()) {
			String temp = a;
			a = b;
			b = temp;
		}
		
		int aIndex = a.length() - 1;
		int bIndex = b.length() - 1;
		int carry = 0;
		String result = "";
		
		while (bIndex >= 0) {
			int sum = Character.getNumericValue(a.charAt(aIndex)) + Character.getNumericValue(b.charAt(bIndex)) + carry;
			carry = sum / 2;
			result = String.valueOf(sum % 2) + result;
			aIndex--;
			bIndex--;
		}
		
		while (aIndex >= 0) {
			int sum = Character.getNumericValue(a.charAt(aIndex)) + carry;
			carry = sum / 2;
			result = String.valueOf(sum % 2) + result;
			aIndex--;
		}
		
		if (carry != 0) {
			result = carry + result;
		}
		
		
		return result;
    }
}
