package com.jiaxin.lc.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

public class WordLadderII {
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> result = new ArrayList<List<String>>();
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		Map<String, Integer> distance = new HashMap<String, Integer>();
		
		dict.add(start);
		dict.add(end);
		
		bfs(map, distance, start, end, dict);
		
		List<String> path = new ArrayList<String>();
		
		dfs(result, path, end, start, distance, map);
		
		return result;
	}

	private void dfs(List<List<String>> result, List<String> path, String current,
			String start, Map<String, Integer> distance,
			Map<String, List<String>> map) {
		
		path.add(current);
		if (current.equals(start)) {
			Collections.reverse(path);
			result.add(new ArrayList<String>(path));
			Collections.reverse(path);
		} else {
			for (String next: map.get(current)) {
				if (distance.containsKey(next) && distance.get(current) == distance.get(next) + 1) {
					dfs(result, path, next, start, distance, map);
				}
			}
		}
		
		path.remove(path.size() - 1);
	}

	private void bfs(Map<String, List<String>> map,
			Map<String, Integer> distance, String start, String end,
			Set<String> dict) {
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		distance.put(start, 0);
		
		for (String s: dict) {
			map.put(s, new ArrayList<String>());
		}
		
		while (!queue.isEmpty()) {
			String word = queue.poll();
			
			List<String> nextList = expand(word, dict);
			for (String next : nextList) {
				map.get(next).add(word);
				if (!distance.containsKey(next)) {  //avoid duplicates
					distance.put(next, distance.get(word) + 1);
					queue.offer(next);
				}
			}
		}
	}

	private List<String> expand(String word, Set<String> dict) {
		List<String> expansion = new ArrayList<String>();
		
		// we also add previous node here. but not influence, distance map will exclude them.
		for (int i = 0; i < word.length(); i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				if (c != word.charAt(i)) {
					String newWord = word.substring(0, i) + c + word.substring(i + 1);
					
					if (dict.contains(newWord)) {
						expansion.add(newWord);
					}	
				}
 			}
		}
		
		return expansion;
	}
	
	@Test
	public void test() {
		Set<String> dict = new HashSet<String>();
		dict.add("hot"); dict.add("dot"); dict.add("dog"); dict.add("lot"); dict.add("log");
		System.out.println(findLadders("hit", "cog", dict));
	}
	
}
