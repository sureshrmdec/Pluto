package com.jiaxin.lc;

import org.junit.Test;

public class IsPalindrome {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		
		String result = "";
		int length = Integer.MAX_VALUE;
		for (String str : strs) {
			length = Math.min(length, str.length());
		}

		for (int i = 0; i < length; i++) {
			for (int j = 1; j < strs.length; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
					return strs[0].substring(0, i);
				}
			}
			result += strs[0].charAt(i);
		}

		return result;
	}





	@Test
	public void test() {
		String[] strs = {"ab"};
		System.out.print(longestCommonPrefix(strs));
	}
}
