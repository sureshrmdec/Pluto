package com.jiaxin.company.linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class ShortestString {
	/**
	 * Given a large document and a short pattern consisting of a few words (eg. W1 W2 W3), 
	 * find the shortest string that has all the words in any order (for eg. W2 foo bar dog W1 cat W3 -- is a valid pattern)
	 * 
	 * Minimum Window in S which Contains All Elements from T
	 * 
	 * https://github.com/sobercheg/InterviewTraining/blob/master/src/careercup/linkedin/WordPatternMatcher.java
	 * @param strs
	 * @param pattern
	 * @return
	 */
	
	// Idea: keep latest positions of every pattern word.
    // If an input word matches a pattern word:
    //  - update its position
    //  - recalculate min distance as: currentPosition - min(pattern word positions)
    //  - remember start and end positions
	
	public String findShortestString(String[] strs, List<String> pattern) {
		String result = "";
		if (strs == null || strs.length == 0 || pattern == null || pattern.size() == 0) {
			return result;
		}
		
		int minDistance = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		Map<String, Integer> wordPosition = new HashMap<String, Integer>();
		
		for (int i = 0 ; i < strs.length; i++) {
			String str = strs[i];
			if (pattern.contains(str)) {
				wordPosition.put(str, i);
				
				if (wordPosition.size() == pattern.size()) {
					int minPosition = Collections.min(wordPosition.values());
					int currentMinDistance = wordPosition.get(str) - minPosition;
					
					if (currentMinDistance < minDistance) {
						minDistance = currentMinDistance;
						start = minPosition;
						end = wordPosition.get(str);
						result = "";
						
						for (int j = start; j <= end; j++) {
							result += strs[j] + " ";
						}
					}
				}
			}
		}
		
		if (wordPosition.size() < pattern.size()) {
			throw new IllegalArgumentException("Can't find a substring matching pattenr");
		}
		
		return result;
	}
	
	@Test
	public void test2() {
		String s = "abc W1 ddd dk W2 df W3 kj W2 W1 d d";
		List<String> pattern = Arrays.asList("W1", "W2", "W3");
		System.out.println(findShortestString(s.split(" "), pattern));
	}
	
	 
	// duplicates
	
	
	/**
	 * Find all the repeating sub-string sequence of specified length in a large string sequence.
	 * The sequences returned i.e. the output must be sorted alphabetically.
	 * 
	 * Input String: "ABCACBABC"  repeated sub-string length: 3  Output: ABC
	 * Input String: "ABCABCA"   repeated sub-string length: 2  Output: AB, BC, CA
	 *   
	 * @param s
	 * @param length
	 * @return
	 */
	public Collection<String> findRepeatingSubString(String s, int length) {
		List<String> result = new ArrayList<String>();
		if (s == null || s.length() == 0 || length == 0) {
			return result;
		}
		
		int i = 0;
		int j = i + length;
		
		Set<String> dict = new HashSet<String>();
		Set<String> repeat = new TreeSet<String>();
		while (j <= s.length()) {
			String sequence = s.substring(i, j);
			if (dict.contains(sequence)) {
				repeat.add(sequence);
			} else {
				dict.add(sequence);
			}
			i++;
			j = i + length;
		}
		
		return repeat;
	}
	
	@Test
	public void test() {
		System.out.println(findRepeatingSubString("ABCACBABC", 3));
		System.out.println(findRepeatingSubString("ABCABCA", 2));
	}
}
