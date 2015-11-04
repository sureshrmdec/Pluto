package com.jiaxin.company.twosigma;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;


import org.junit.Test;


public class Solution {

	static Map<String, Integer> distance = new HashMap<String, Integer>();

    static int longest_chain(String[] w) {
        int maxLength = Integer.MIN_VALUE;
        
        List<String> toFind = Arrays.asList(w);
		/*
		Collections.sort(toFind, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});
		*/
		for (int i = 0; i < toFind.size(); i++) {
			if (distance.containsKey(toFind.get(i))) {
				continue;
			}
			
			distance.put(toFind.get(i), 0);
			int length = helper(toFind.get(i), toFind); 
			maxLength = Math.max(maxLength, length);
		}
        
        return maxLength;
    }


    static int helper(String word, List<String> words) {
        // get all available word in the list by remove one char.  
        
        int level = 1;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(word);

        while (!queue.isEmpty()) {
        	word = queue.poll(); 
        	List<String> available = translate(word, words);
        	
        	if (!available.isEmpty()) {
        		for (String next: available) {
        			queue.add(next);
    			}
        		level++;
        	}
        }
		 
		return level;
    }

    static List<String> translate(String word, List<String> dict) {
		List<String> list = new ArrayList<String>();
		
        if (word.length() == 1) {
            return list;
        }
		
		for (int i = 0; i < word.length(); i++) {
			String newWord = word.substring(0, i) + word.substring(i + 1);
			
			if (distance.containsKey(newWord)) {
				continue;
			}
			
			if (dict.contains(newWord)) {
				list.add(newWord);
			}
		}
		
		return list;
	}
    @Test
	public void test1() {
//		Set<String> dict = new HashSet<String>() {{add("a");  add("ab"); add("abc"); add("abd");}};
//		List<String> dict = new ArrayList<String>();
		String[] dict = new String[4];
		dict[0] = "a";
		dict[1] = "ab";
		dict[2] = "abc";
		dict[3] = "abd";
		
		System.out.println(longest_chain((dict)));
	}
	
	@Test
	public void test2() {
//		Set<String> dict = new HashSet<String>() {{add("a");  add("ab"); add("abc"); add("abd");}};
		String[] dict = new String[4];
		System.out.println(longest_chain(dict));
	}
	
	@Test
	public void test3() {
//		Set<String> dict = new HashSet<String>() {{add("x"); add("xy"); add("xyz"); add("abd"); add("abcd");}};
		String[] dict = new String[5];
		dict[0] = "x";
		dict[1] = "y";
		dict[2] = "xyz";
		dict[3] = "abd";
		dict[4] = "abcd";
		System.out.println(longest_chain(dict));
	}
	
	@Test
	public void test4() {
//		Set<String> dict = new HashSet<String>() {{add("a"); add("b"); add("ba"); add("bca"); add("bda"); add("bdca");}};
		String[] dict = new String[6];
		dict[0] = "a";
		dict[1] = "b";
		dict[2] = "ba";
		dict[3] = "bca";
		dict[4] = "bda";
		dict[5] = "bdca";
		System.out.println(longest_chain(dict));
	}
}
