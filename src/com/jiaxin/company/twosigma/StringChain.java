package com.jiaxin.company.twosigma;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.junit.Test;


/**
 * input: ["a", "b", "ba", "bca", "bda", "bdca"] 
 * output: 4 ("bdca"->"bca"->"ba"->"a") ("bdca"->"bda"->"ba"->"b") could be another solution 
 * 
 * Find longest String chain.
 * 
 * @author jiashan
 *
 */
public class StringChain {
	
	Map<String, Integer> distance = new HashMap<String, Integer>();
	public int stringChainLength(Set<String> words) {
		int maxLength = Integer.MIN_VALUE;
		
		List<String> toFind = new ArrayList<String>(words);
		Collections.sort(toFind, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});
		
		for (int i = 0; i < toFind.size(); i++) {
			int length = helper(toFind.get(i), words); 
			maxLength = Math.max(maxLength, length);
		}
		
		return maxLength;		
	}
	
	// get max Length of a word.
	private int helper(String word, Set<String> words) {
		int level = 1;
		
		if (distance.containsKey(word)) {
			return distance.get(word);
		} 
					
		List<String> available = translate(word, words);
		if (!available.isEmpty()) {
			int max = Integer.MIN_VALUE;
			for (String next: available) {
				max =  Math.max(max, helper(next, words));
			}
			
			level += max;
		} 
		
		distance.put(word, level); 
		return distance.get(word);
	}

	// get available word list in dictionary
	private List<String> translate(String word, Set<String> dict) {
		List<String> list = new ArrayList<String>();
		
		for (int i = 0; i < word.length(); i++) {
			String temp = word.substring(0, i) + word.substring(i + 1);
			if (dict.contains(temp)) {
				list.add(temp);
			}
		}
		
		return list;
	}


	@Test
	public void test() {
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		dict.add("ba");
		dict.add("bca");
		dict.add("bda");
		dict.add("bdca");
		
		System.out.println(stringChainLength(dict));
	}
	
	
}
