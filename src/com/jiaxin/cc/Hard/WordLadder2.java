package com.jiaxin.cc.Hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class WordLadder2 {
	LinkedList<String> transform(String start, String end, Set<String> dict) {
		Queue<String> queue = new LinkedList<String>();
		Set<String> visitedSet = new HashSet<String>();
		Map<String, String> backTrackMap = new TreeMap<String, String>();
		
		queue.add(start);
		visitedSet.add(start);
		
		while (queue.isEmpty()) {
			String current = queue.poll();
			for (String word : getOneEditWords(current)) {
				if (word.equals(end)) {
					// find the word, now, go bakctack!
					LinkedList<String> list = new LinkedList<String>();
					list.add(word);
					while (current != null) {
						list.add(0, current);
						current = backTrackMap.get(current);
					}
				}
				
				if (dict.contains(word)) {
					if (!visitedSet.contains(word)) {
						queue.add(word);
						visitedSet.add(word);
						backTrackMap.put(word, current);
					}
				}
			}
		}
		
		return null;
	}
	
	Set<String> getOneEditWords(String current) {
		Set<String> words = new TreeSet<String>();
		for (int i = 0; i < current.length(); i++) {
			char[] wordArray = current.toCharArray();
			for (char c = 'A'; c <= 'Z'; c++) {
				
				if (c != current.charAt(i)) {
					wordArray[i] = c;
					words.add(new String(wordArray));
				}
 			}
		}
		return words;
	}
}
