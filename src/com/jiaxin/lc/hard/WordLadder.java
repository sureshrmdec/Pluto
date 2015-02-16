package com.jiaxin.lc.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

public class WordLadder {
	// BFS
	public int ladderLength(String start, String end, Set<String> dict) {
		if (start == null || end == null || dict == null || dict.size() == 0) {
			return 0;
		}
		
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		dict.remove(start);
		int level = 1;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				String word = queue.poll();
				
				for (int j = 0; j < word.length(); j++) {
					for (char c = 'a'; c <= 'z'; c++) {
						String newWord = replaceChar(word, j, c);
						
						if (newWord.equals(end)) {
							return level + 1;
						}
						
						if (dict.contains(newWord)) {
							queue.offer(newWord);
							dict.remove(newWord);
						}
					}
				}
			}
			
			level++;
		}
		
		return 0;
	}

	private String replaceChar(String start, int j, char c) {
		char[] array = start.toCharArray();
		array[j] = c;
		
		return new String(array);
	}
	
	@Test
	public void test() {
		Set<String> dict = new HashSet<String>();
		dict.add("hot"); dict.add("dog"); dict.add("dot");
		System.out.println(ladderLength("hot", "dog", dict));
	}
	
}
