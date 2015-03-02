package com.jiaxin.company.fb.onsite;

import org.junit.Test;

/**
 * Decode ways (Recursive + DP)
 * Count and say
 * 
 * @author jiashan
 *
 */
public class FBDecodeWays {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int[] num = new int[s.length() + 1];
		num[0] = 1;
		num[1] = s.charAt(0) == '0' ? 0 : 1; 

		for (int i = 2; i <= s.length(); i++) {
			if (s.charAt(i - 1) != '0') {
				num[i] = num[i - 1];
			}

			int twoDigit = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
			if (twoDigit >= 10 && twoDigit <= 26) {
				num[i] += num[i - 2];
			}
	 	}

	 	return num[s.length()];
	}
	
	
	public int numDecodingRecursive(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		if (s.length() == 1) {
			// Important, one corner case here.
			return s.charAt(0) == '0' ? 0 : 1;
		}
		
		int first = s.charAt(0) - '0';
		int second = s.charAt(1) - '0';
		
		int twoDigit = first * 10 + second;
		
		if (twoDigit >= 10 && twoDigit <= 26) {
			if (s.length() == 2) {
				return 1 + numDecodingRecursive(s.substring(1)); 
			} else {
				return numDecodingRecursive(s.substring(1)) + numDecodingRecursive(s.substring(2));
			}
			// Here, Important, make sure there's 0, return 0 and stop calculation.
		} else if (first == 0 || second == 0) {
			return 0;
		}

		return numDecodingRecursive(s.substring(1));
	}
	
	@Test
	public void test() {
		String s1 = "1111212433498";  // general
		System.out.println(numDecodings(s1) + " " + numDecodingRecursive(s1));
		String s2 = "1213213033498";  //invalid twoDigit
		System.out.println(numDecodings(s2) + " " + numDecodingRecursive(s2));
		String s3 = "121212033498";  // valid twoDigit
		System.out.println(numDecodings(s3) + " " + numDecodingRecursive(s3));
		String s4 = "0";  // s.length() == 1 case.
		System.out.println(numDecodings(s4) + " " + numDecodingRecursive(s4));
	}
}
