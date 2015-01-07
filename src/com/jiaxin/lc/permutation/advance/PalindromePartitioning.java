package com.jiaxin.lc.permutation.advance;

import java.util.ArrayList;
import java.util.List;
// https://oj.leetcode.com/discuss/9476/solution-does-not-need-table-palindrome-right-uses-only-space
public class PalindromePartitioning {
    // "aab" -> ["aa", "b"]  ["a", "a", "b"]
	
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();
		
		if (s == null || s.length() == 0) {
			return result;
		}
		
		helper(result, list, s, 0);
		
		return result;
	}

	private void helper(List<List<String>> result, List<String> list, String s, int position) {
		if (position == s.length()) {
			result.add(new ArrayList<String>(list));
			return;
		}
		
		for (int i = position; i < s.length(); i++) {
			String prefix = s.substring(position, i + 1);
			if (!isPanlindrom(prefix)) {
				continue;
			}
			
			list.add(prefix);
			helper(result, list, s, i + 1);
			list.remove(list.size() - 1);
		}
		
	}

	private boolean isPanlindrom(String prefix) {
		int start = 0;
		int end = prefix.length() - 1;
		
		while (start < end) {
			if (prefix.charAt(start) != prefix.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		
		return true;
	}
	
	
}
