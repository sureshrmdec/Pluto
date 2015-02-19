package com.jiaxin.lc.dp.sequence;

import org.junit.Test;


public class DecodeWays {
	// Test case: "10", "100"  if 0 apears and can't form a two digits. it will be 0. can't be decoded.
	public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int[] num = new int[s.length() + 1];
		num[0] = 1;
		num[1] = s.charAt(0) == '0' ? 0: 1;
		
		for (int i = 2; i <= s.length(); i++) {
			if (s.charAt(i - 1) != '0') {
				num[i] = num[i - 1];
			}
			
			int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
			if (twoDigits >= 10 && twoDigits <= 26) {
				num[i] += num[i - 2];
			}
		}
		
		return num[s.length()];
    }
	
	// Recursive http://stackoverflow.com/questions/20342462/review-an-answer-decode-ways
	// https://gist.github.com/janehwzn/5937872
	
	public int numDecodingsRecursive(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
        // terminate condition
        if (s.length() == 1) {
			return s.charAt(0) == '0' ? 0 : 1; 
		} 
        
        
        int first = s.charAt(0) - '0';
		int second = s.charAt(1) - '0';
        
		int twoDigit = first * 10 + second;
		
		if (twoDigit >= 10 && twoDigit <= 26) {
			if (s.length() == 2) {
				return 1 + numDecodings(s.substring(1));
			} else {
				return numDecodings(s.substring(1)) + numDecodings(s.substring(2));
			}
		}
		
		return numDecodings(s.substring(1));
	}
	
	
	@Test
	public void test() {
		String s = "1584232141014";
		
		System.out.println(numDecodings(s));
		System.out.println(numDecodingsRecursive(s));
	}
}
