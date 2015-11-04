package com.jiaxin.company.fb.online;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;


/**
 * Given a string list, find all pairs of strings which can be combinated to be a palindrome. 
 * eg. cigar + tragic -> cigartragic, none + xenon -> noneexenon. 
 * 
 * n words, every length m 
 * 
 * @author jiashan
 *
 */
public class PalindromePair {
	public List<String> palindromePair(List<String> words) {
		List<String> result = new ArrayList<String>();
		if (words == null || words.size() == 0) {
			return result;
		}
		
		
		
		// aba gar rag
		
		return result;
	}
	
	public List<List<String>> getPairs(Set<String> dict){
		List<List<String>> result = new ArrayList<List<String>>();
		for (String s : dict) {
			for (int i = 0; i < s.length(); ++i) {
				String s1 = s.substring(0, i);
				String s2 = s.substring(i, s.length());
				if (isPalindrome(s1)) {
					judge(result, s, s2, dict, false);
				}
				if (isPalindrome(s2)) {
					judge(result, s, s1, dict, true);
				}
			}
		}
		return result;
	}
	public void judge(List<List<String>> result, String s, String compare, Set<String> dict, boolean position){
		char[] array = compare.toCharArray();
		
		// reverse this part.
		for (int j = 0; j < compare.length() / 2; ++j) {
			char c = array[j];
			array[j] = array[compare.length() - j - 1];
			array[compare.length() - j - 1] = c;
		}
		
		String reverse = new String(array);
		
		if (dict.contains(reverse) && !reverse.equals(s)) {
			List<String> list = new ArrayList<String>();
			list.add(s);
			list.add(reverse);

			result.add(list);
		}
	}
	public boolean isPalindrome(String s){
		if (s.length() <= 1)
			return true;
		
		int left = 0;
		int right = s.length() - 1;
		
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
				
			++left;
			--right;
		}
		
		return true;
	}
	
	@Test
	public void test(){
//		String[] arr = {"a", "aa", "aaa", "abc", "cba", "shit", "ihs"};
		String[] arr = {"abacgi", "igc"};
		Set<String> dict = new HashSet<String>();
		for(String s : arr)
			dict.add(s);

		
        List<List<String>> result = getPairs(dict);
        for(List<String> list : result){
        	for(String ss: list){
        		System.out.print(ss+" ");
        	}
        	System.out.println();
        }
	}
}
