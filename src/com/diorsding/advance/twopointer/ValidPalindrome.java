package com.diorsding.advance.twopointer;

import org.junit.Test;

/**
 * http://www.lintcode.com/en/problem/valid-palindrome/
 * Challenge: O(n) time without extra memory.
 * 
 * Solution: Two Pointer. opposite position.  O(n) time without extra memory.
 * 
 * Character.isAlphabetic('1') -> false
 * Character.isLetterOrDigit('1') -> true
 * Character.toLowerCase('1') -> 1   This is available for digit.
 * 
 *
 * 
 * @author jiashan
 *
 */
public class ValidPalindrome {
	
	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		
		// char[] chars = s.toCharArray(); // can not be used cause extra memory violated.
		
		int left = 0;
		int right = s.length() - 1;
		
		while (left < right) {
			char leftChar = Character.toLowerCase(s.charAt(left));
			char rightChar = Character.toLowerCase(s.charAt(right));
			
			if (!Character.isLetterOrDigit(leftChar)) {
				left++;
				continue;
			}
			
			if (!Character.isLetterOrDigit(rightChar)) {
				right--;
				continue;
			}
			
			if (leftChar != rightChar) {
				return false;
			}
			
			left++;
			right--;
		}
		
		return true;
    }
	
	@Test
	public void test() {
		//System.out.println(Character.isAlphabetic('1'));  only available in Java 7.
		System.out.println(Character.isLetterOrDigit('1'));
		System.out.println(Character.toLowerCase('1'));
	}
	
}
