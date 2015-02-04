package com.jiaxin.company.linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * 
 * @author jiashan
 * You have a large text file containing words. Given any two words, find the 
 * shortest distance (in terms of number of words) between them in the file. If the 
 * operation will be repeated many times for the same file (but different pairs of 
 * words), can you optimize your solution?
 * 
 */
public class ShortestDistance {
	
	// call one time 
	public int shortestDistance(String[] words, String s, String t) {
		if (words == null || s == null || t == null) {
			return 0;
		}
		
		int indexS = -1;
		int indexT = -1;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(s)) {
				indexS = i;
				int dis = indexS - indexT;
				if (indexT >= 0 && dis < min) {
					min = dis;
				}
			} else if (words[i].equals(t)) {
				indexT = i;
				int dis = indexT - indexS;
				if (indexS >= 0 && dis < min) {
					min = dis;
				}
			}
		}
		
		return min;
	}
	
	// call for multiple time -- preprocess
	public int shortestDistanceMap(String[] words, String s, String t) {
		Map<String, List<Integer>> dict = new HashMap<String, List<Integer>>();
		
		for (int i = 0; i < words.length; i++) {
			if (!dict.containsKey(words[i])) {
				dict.put(words[i], new ArrayList<Integer>());
			}
			dict.get(words[i]).add(i);
		}
		
		List<String> mergeList = merge(dict.get(s), dict.get(t));
		
		return findmin(mergeList);
	}

	private int findmin(List<String> mergeList) {
		int min = Integer.MAX_VALUE;		
		
		for (int i = 1; i < mergeList.size(); i++) {
			String last = mergeList.get(i - 1);
			String current = mergeList.get(i);
			
			if (last.charAt(last.length() - 1) == current.charAt(current.length() - 1)) {
				continue;
			}
			
			min = Math.min(min, Integer.parseInt(current.substring(0, current.length() - 1)) 
					- Integer.parseInt(last.substring(0, last.length() - 1)));
		}
		
		return min;
	}

	private List<String> merge(List<Integer> a, List<Integer> b) {
		List<String> mergeList = new ArrayList<String>(a.size() + b.size());
		
		int i = 0;
		int j = 0;
		
		while (i < a.size() && j < b.size()) {
			if (a.get(i) < b.get(j)) {
				mergeList.add(String.valueOf(a.get(i)) + 'a');
				i++;
			} else {
				mergeList.add(String.valueOf(b.get(j)) + 'b');
				j++;
			}
		}
		
		while (i < a.size()) {
			mergeList.add(String.valueOf(a.get(i)) + 'a');
			i++;
		}
		
		while (j < b.size()) {
			mergeList.add(String.valueOf(b.get(j)) + 'b');
			j++;
		}
		
		return mergeList;
	}
	
	@Test
	public void test() {
		String s = "We will assume for this question that it doesn't matter whether wordl or word2 appears"
				+ "first. This is a question you should ask your interviewer. If the word order does matter, we"
				+ "can make the small modification shown in the code below";
		
		String[] words = s.split(" ");
		System.out.println(shortestDistance(words, "We", "assume"));
	}
}
