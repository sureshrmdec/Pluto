package com.jiaxin.lc.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;


public class WordBreakII {

	public List<String> wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0 || dict == null) {
			return new ArrayList<String>();
		}
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		return helper(s, dict, map);
	}

	
	private List<String> helper(String s, Set<String> dict, Map<String, List<String>> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		}
		List<String> result = new ArrayList<String>();
		
		int length = s.length();
		if (length <= 0) {
			return result;
		}
		
		for (int i = 1; i <= length; i++) {
			String prefix = s.substring(0, i);
			
			if (dict.contains(prefix)) {
				if (i == s.length()) {
					result.add(prefix);
				} else {
					String suffix = s.substring(i);
					List<String> temp = helper(suffix, dict, map);
					
					for (String word : temp) {
						word = prefix + " " + word;
						result.add(word);
					}
				}
			}
		}
		
		map.put(s, result);
		return result;
	}


	@Test
	public void test() {
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.addAll(new ArrayList<String>(Arrays.asList("cat", "cats", "and", "sand", "dog")));
		
		System.out.println(wordBreak(s, dict));
	}
	
}
