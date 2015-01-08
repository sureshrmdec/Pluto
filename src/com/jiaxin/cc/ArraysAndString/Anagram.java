package com.jiaxin.cc.ArraysAndString;
/**
 * 1.3 Given two strings, write a method to decide if one is a permutation of the other
 * 
 * I misunderstand the defination of permutation. I treat it as reverse.
 * Permutation means anyway, but reversed.  abb is a permutation of bab.  
 * Permutation feature: the count of ever number is same, any combination is valid 
 */
public class Anagram {

	public void main(String[] args) {
		System.out.println(permutation("fabcdfedfaaa","abacdaedfaff"));
	}
	
	/**
	 * Check if the two strings have identical character counts -- the permutation is not same as I think
	 * 
	 * make ever char as position, and increase 	 
	 */
	public boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		int[] arr = new int[256]; // assume character is ASCII
		for (int i = 0; i < s.length(); i++) {
			char value = s.charAt(i);
			arr[value]++;
		}

		for (int i = 0; i < t.length(); i++) {
			int value = t.charAt(i);
			if (--arr[value] < 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Sort two strings and compare(use sort api) 
	 */
	public boolean permutation2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		
		return sort(s).equals(sort(t));
	}

	public String sort(String str) {
		char[] temp = str.toCharArray();
		java.util.Arrays.sort(temp);
		return new String(temp);
	}
}
