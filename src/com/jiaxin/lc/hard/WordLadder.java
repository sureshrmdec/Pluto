package com.jiaxin.lc.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	// BFS
	public int ladderLength(String start, String end, Set<String> dict) {
		if (start == null || end == null || dict == null || dict.size() == 0) {
			return 0;
		}
		
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		dict.remove(start);
		int level = 0;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				String word = queue.poll();
				
				for (int j = 0; j < word.length(); j++) {
					for (char c = 'a'; c < 'z'; c++) {
						if (word.charAt(j) == c) {
							continue;
						}
						
						String temp = replaceChar(start, j, c);
						
						if (temp.equals(end)) {
							return level + 1;
						}
						
						if (dict.contains(temp)) {
							queue.offer(temp);
							dict.remove(temp);
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
	
	
	/*******************************************************************************************************************/
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> result = new ArrayList<List<String>>();
//		List<String> path = 
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		Map<String, Integer> distance = new HashMap<String, Integer>();
		
		bfs(map, distance, start, end, dict);
		
		
		
		return null;
	}

	private void bfs(Map<String, List<String>> map, Map<String, Integer> distance, 
			String start, String end, Set<String> dict) {
		
		
	}
	
	
	
	
}
