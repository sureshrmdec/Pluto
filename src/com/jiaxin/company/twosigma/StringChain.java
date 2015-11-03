package com.jiaxin.company.twosigma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


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
	
	public int stringChainLength(Set<String> words) {
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		Map<String, Integer> distance = new HashMap<String, Integer>();
		
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		String longestWord = ""; 
		for (String word : words) {
			if (word.length() > max) {
				longestWord = word;
				max = word.length();
			}
			min = Math.min(min, word.length());
		}
		
		// start with longest do not make sure.. 
		
		Queue<String> queue = new LinkedList<String>();
		queue.offer(longestWord);
		int level = 1;
		
		for (String word : words) {
			map.put(word, new ArrayList<String>());
		}
		
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				String word = queue.poll();
				
				List<String> available = translate(word, words, queue);
				for (String next: available) {
					map.get(next).add(word);
					
					if (distance.containsKey(next)) {
						distance.put(next, distance.get(word) + 1);
						queue.offer(next);
					}
				}
			}
			
			
			
			
			

			
			
		}
		
		return 0;
	}
	
	
	
	private List<String> translate(String word, Set<String> dict, Queue<String> queue) {
		List<String> list = new ArrayList<String>();
		
		for (int i = 0; i < word.length(); i++) {
			String temp = word.substring(0, i) + word.substring(i + 1);
			
			if (dict.contains(temp)) {
				list.add(temp);
			}
		}
		
		return list;
	}



	public List<String> stringChain(List<String> words) {
		Map<String, Integer> map = new HashMap<String, Integer>(); 
		
		List<String> chain = new ArrayList<String>();
		
		
		return null;
	}
	
	
	
}
