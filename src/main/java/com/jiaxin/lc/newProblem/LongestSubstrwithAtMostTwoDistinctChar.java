package com.jiaxin.lc.newProblem;

import org.junit.Test;

/**
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 * For example, Given s = “eceba”, T is "ece" which its length is 3.
 * 
 * 1）如果当前字符跟前一个字符是一样的，直接继续。
 * 2）如果不一样，则需要判断当前字符跟j是不是一样的
 *   a）一样的话sliding window左边不变，右边继续增加，但是j的位置需要调整到k-1。
 *   b）不一样的话，sliding window的左侧变为j的下一个字符（也就是去掉包含j指向的字符的区间），j的位置也需要调整到k-1。
 * 
 * @author jiashan
 *
 */
public class LongestSubstrwithAtMostTwoDistinctChar {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int i = 0, j = -1, maxLen = 0;
		
		for (int k = 1; k < s.length(); k++) {
			if (s.charAt(k) == s.charAt(k - 1)) {
				continue;
			}
				
			if (j >= 0 && s.charAt(j) != s.charAt(k)) {
				maxLen = Math.max(k - i, maxLen);
				i = j + 1;
			}
			
			j = k - 1;
		}
		
		return Math.max(s.length() - i, maxLen); // we need this since the last char could be same as previous one.
    }
	
	@Test
	public void test() {
		String s = "ecebaaa";
		System.out.println(lengthOfLongestSubstringTwoDistinct(s));
	}
}
