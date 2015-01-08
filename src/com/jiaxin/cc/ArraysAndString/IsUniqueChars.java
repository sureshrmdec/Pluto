package com.jiaxin.cc.ArraysAndString;

import java.util.HashSet;
import java.util.Set;

/**
 * 1.1 Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures ?
 */
public class IsUniqueChars {
	
	public static void main(String args[]) {
		System.out.println(isUniqueChars("abcdefghijklmnopqrstuvwxyz"));
	}
	
	/**
	 * Book's solution, just use boolean[] replaces Set, I need to understand unique characters!
	 * Then I could know I can create to boolean[256] to flag exist character.
	 * 
	 * In additon, no need to convert string to charArray,just use charAt(), save some space 
	 * 
	 * Conclusion: 1.understand unicode & ascII character.(only 256 characters) 2. study using boolean[] as flag
	 * In my solution, I just judge str == null and str.length() ==0 but not use str.length() >256
	 * 
	 */
	public static boolean isUniqueChars(String str) {
		if (str.length() > 256) {
			return false;
		}

		boolean[] flag = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i); // char or int? what's the relationship
										
			if (flag[temp]) {
				return false;
			} else {
				flag[temp] = true;
			}
		}
		return true;
	}
	
	// Bit Vector --> save more time. Assume only lowercase (26), just need a integer(32 bit), 直接就移位就可以啦
	public boolean isUniqueCharsBitVector(String str) {
		if (str.length() > 256) {
			return false;
		}
		
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.length() - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			
			checker |= (1 << val);
		}
		
		return true;
	}
	
	
	/**
	 * Extra Data Structure Solution
	 * unique --> Set
	 */
	public static boolean isUniqueChars2(String str) {
		if (str == null) {
			return false;
		}

		Set<Character> set = new HashSet<Character>();
		char[] arr = str.toCharArray();

		for (int i = 0; i < str.length(); i++) {
			if (set.contains(arr[i])) {
				return false;
			} else {
				set.add(arr[i]);
			}
		}

		return true;
	}
	
	/**
	 * brute force solution
	 * No extra data structure and space but time complexity increase   
	 */
	public static boolean isUniqueChars3(String str) {
		if (str == null) {
			return false;
		}
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					return false;
				}
			}
		}
		return true;
	}
}
