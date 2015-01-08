package com.jiaxin.cc.Hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 18.7 Given a list of words, write a program to find the longest word made of other words in the list
 * Input: cat, banana, dog, nana, woalk, walker, dogwalker
 * Output: dogwalker
 * 
 * Solution: 我开始向的是组合，书上是拆最长串，其实就是word break II的思路. input中招最长串开始拆而已 
 * 扩展之后，从长度到小排序，从小就错了，当前word会被赋值false. 后面切不出来了
 * 
 * isOriginal 主要用来控制hashmap碰到自己这个词，不立刻返回. 查分以后，设置成false, 就可以直接用map返回结果了
 * @author jeffwan
 * @date May 24, 2014
 */

public class LongestWord {
	public static void main(String[] args) {
		String[] words = {"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"};
		System.out.println(printLonestWord(words));
	}
	
	// 这只是个sample解决两个人问题
	public static String getLongestWord(String[] words) {
		if(words == null || words.length == 0) {
			return null;
		}
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		for (String word : words) {
			map.put(word, true);
		}
		
		for (String word: words) {
			for (int i = 1; i < word.length(); i++) {
				String left = word.substring(0, i);
				String right = word.substring(i);
				
				if (map.get(left) != null && map.get(right) != null) {
					return word; 
				}
			}
		}
		
		return null;
	}
	
	// Extension: 扩展了以后的可以计算多个词，DP+Recursive. map 记录不能分割的词， recursive，切一个词就把右边recursive
	public static String printLonestWord(String[] words) {
		if (words == null || words.length == 0) {
			return null;
		}
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		for (String word : words) {
			map.put(word, true);
		}
		
		Arrays.sort(words, new LengthComparactor());
		System.out.println(Arrays.toString(words));
		for (String word : words) {
			if (canBuildWord(word, true, map)) {
				return word;
			}
		}
		
		return "";
	}
	
	private static boolean canBuildWord(String word, boolean isOriginalWord, HashMap<String, Boolean> map) {
		if (map.containsKey(word) && !isOriginalWord) {
			return map.get(word);
		}
		
		for (int i = 1; i < word.length(); i++) {
			String left = word.substring(0, i);
			String right = word.substring(i);
			if (map.containsKey(left) && map.get(left) == true && canBuildWord(right, false, map)) {
				return true;
			}
		}
		
		map.put(word, false);
		return false;
	}

	public static class LengthComparactor implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			return o2.length() - o1.length();
		}		
	}
	
}
