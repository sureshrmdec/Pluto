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
		
		String s5 = "6165812287883668764831544958683283296479682877898293612168136334983851946827579555449329483852397155";
		System.out.println(numDecodings(s5) + " " + numDecodingRecursive(s5));
	}
	
	public int decodeWaysArray(int[] A) {
	    if (A == null || A.length == 0) {
	        return 0;
	    }
	    
	    int[] num = new int[A.length + 1];
	    num[0] = 1;
	    num[1] = A[0] == 0 ? 0 : 1;
	    
	    for (int i = 2; i <= A.length; i++) {
	        if (A[i - 1] != 0) {
	            num[i] = num[i - 1];
	        }
	        
	        int digit = A[i - 2] * 10 + A[i - 1];
	        if (digit >= 10 && digit <= 26) {
	            num[i] += num[i - 2];
	        }
	    }
	    
	    return num[A.length];
	}

	public int decodeWays(int[] A) {
	    if (A == null || A.length == 0) {
	        return 0;
	    }
	    
	    return decode(A, 0);
	}

	public int decode(int[] A, int i) {
	    if (i == A.length - 1) {
	        return A[i] == 0 ? 0: 1; 
	    }
	    
	    int first = A[i];
	    int second = A[i + 1];
	    
	    int digit = first * 10 + second; 
	    
	    if (digit >= 10 && digit <= 26) {
	        if (i == A.length - 2) {
	            return 1 + decode(A, i + 1);
	        } else {
	            return decode(A, i + 1) + decode(A, i + 2);
	        } 
	    } else if (first == 0 || second == 0) {
	        return 0;
	    }
	    
	    return decode(A, i + 1);
	}
	
	@Test
	public void test2() {
		int[] A = {1,1,1}; // general
		System.out.println(decodeWaysArray(A) + " " + decodeWays(A));
		int[] B = {1,1,0};  //invalid twoDigit
		System.out.println(decodeWaysArray(B) + " " + decodeWays(B));

	}
	
}
