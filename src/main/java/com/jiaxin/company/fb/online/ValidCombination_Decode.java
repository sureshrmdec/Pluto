package com.jiaxin.company.fb.online;

import java.util.List;

import org.junit.Test;

/**
 * The number of valid combinations of a strings for given input array a[], 
 * where a=>1, z => 26, and 0 <= a <= 9
 * {1,1,1} => { aaa, ak, ka} => 3
 * {1,1,0} => {aj} => 1
 * 
 * follow up: O(1) memory
 * 
 * @author jiashan
 *
 */
public class ValidCombination_Decode {
	public List<List<String>> combination() {
		return null;
		
	}
	
	public int numDecodings(String s) {
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
	
	public int combinationRecursive(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		return search(A, 0);
	}
	
	private int search(int[] A, int i) {
		if (i >= A.length) {
			return 0;
		}
		
		if (i == A.length - 1) {
			return A[i] == 0? 0 : 1;
		}
		
		if (i == A.length - 2) {
			int first = A[i];
			int second = A[i + 1];
			
			int twoDigit = first * 10 + second;
			
			if (twoDigit >= 10 && twoDigit <= 26) {
				return 1;
			}
		}
		
		return search(A, i + 1) + search(A, i + 2);
	}

	public int combinationDP(int[] A) {
		int[] num = new int[A.length + 1];
		num[0] = 1;
		num[1] = A[0] == 0 ? 0 : 1;
		
		for (int i = 2; i <= A.length; i++) {
			if (A[i - 1] != 0) {          // if 0 means invalid.
				num[i] = num[i - 1];	
			}
			
			int twoDigits = A[i - 2] * 10 + A[i - 1];
			if (twoDigits >= 10 && twoDigits <= 26) {
				num[i] += num[i - 2];
			}
		}
		
		return num[A.length];
	}
	
	@Test
	public void test() {
		int[] A = {1, 1, 3, 6, 2, 3};
		
		System.out.println(combinationDP(A));
		System.out.println(numDecodings("113623"));
	}
	
}
