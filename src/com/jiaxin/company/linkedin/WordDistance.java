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
public class WordDistance {
	/* This class will be given a list of words (such as might be tokenized
	 * from a paragraph of text), and will provide a method that takes two
	 * words and returns the shortest distance (in words) between those two
	 * words in the provided text. 
	 * Example:
	 *   WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList("the", "quick", "brown", "fox", "quick"));
	 *   assert(finder.distance("fox","the") == 3);
	 *   assert(finder.distance("quick", "fox") == 1);
	 */
	
	// call one time  -> O(n) Time, O(1) Space
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
	
	
	/**************************************************************************************/
	// call for multiple time -- preprocess
	public int shortestDistanceMap(String[] words, String s, String t) {
		Map<String, List<Integer>> dict = new HashMap<String, List<Integer>>();
		
		for (int i = 0; i < words.length; i++) {
			if (!dict.containsKey(words[i])) {
				dict.put(words[i], new ArrayList<Integer>());
			}
			dict.get(words[i]).add(i);
		}
		
		/*
		List<String> mergeList = merge(dict.get(s), dict.get(t));
		
		return findmin(mergeList);
		*/
		
		List<Integer> list1 = dict.get(s);
		List<Integer> list2 = dict.get(t);
		
		int i = 0, j = 0;
		int result = Integer.MAX_VALUE;
		
		while (i < list1.size() && j < list2.size()) {
			if (list1.get(i) <= list2.get(j)) {
				result = Math.min(result, list2.get(j) - list1.get(i));
				i++;
			} else {
				result = Math.min(result, list1.get(i) - list2.get(j));
				j++;
			}
		}
		
		return result;
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

	// You have two arrays of integers, where the integers do not repeat and the two arrays have no common integers. 
	// Let x be any integer in the first array, y any integer in the second. Find min(Abs(x-y)). That is, find the 
	// smallest difference between any of the integers in the two arrays. 
	// Assumptions: Assume both arrays are sorted in ascending order.
	
	public int minTwoArray(int[] A, int[] B) {
		int i = 0;
		int j = 0;
		int result = Integer.MAX_VALUE;
		
		while (i < A.length && j < B.length) {
			if (A[i] <= B[j]) {
				result = Math.min(result, B[j] - A[i]);
				i++;
			} else {
				result = Math.min(result, A[i] - B[j]);
				j++;
			}
		}
		return result;
	}
	
	
	
	@Test
	public void test() {
		String s = "We will assume for this question that We doesn't interviewer whether wordl or interviewer appears"
				+ "first. This is a question We should ask your interviewer. If the word order does matter, We"
				+ "can make the small modification shown in the code below";
		
		String[] words = s.split(" ");
		System.out.println(shortestDistanceMap(words, "We", "interviewer"));
		
		int[] A = {1,5,6};
		int[] B = {3,4,18,30};
		System.out.println(minTwoArray(A, B));
	}
}
